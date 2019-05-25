//
//  BTApiManager.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 23/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit
import Alamofire

let baseURL = "http://vps690962.ovh.net:8080/"
let tokenURL = "v1/token/generate"
let saveURL = "v1/sample/save"
let scoreURL = "v1/score/top"
let myScoreURL = "v1/score/my"
let isAliveURL = "http://vps690962.ovh.net:8082/ops/health"

class BTApiManager: NSObject
{
    static let sharedManager = BTApiManager()
    
    private var lastSend : Date?

    private override init()
    {
        super.init()
        
        lastSend = Date()
    }
    
    func isAlive(handler: @escaping (Bool) -> Void)
    {
        guard let url = URL(string: isAliveURL) else {
            handler(false)
            return
        }
        
        Alamofire.request(url, method: .get, parameters: nil).validate().responseJSON { response in
            guard response.result.isSuccess else {
                handler(false)
                return
            }
        
            guard let value = response.result.value as? [String: String] else {
                handler(false)
                return
            }
                
            if value["status"] == "UP"
            {
                handler(true)
            }
            else
            {
                handler(false)
            }
        }
    }
    
    public func registerUser(name: String, handler: @escaping (Bool) -> Void)
    {
        if BTKeychainManager.sharedManager.getToken().count > 0
        {
            BTUserManager.sharedManager.setUserLoginStatus(status: .LoginStatusSuccessful)

            handler(true)
            return
        }
        
        guard let url = URL(string: baseURL + tokenURL) else {
            handler(false)
            return
        }
        
        Alamofire.request(url, method: .get, parameters: ["name" : name]).validate().responseJSON { response in
            guard response.result.isSuccess else {
                handler(false)
                return
            }
            
            guard let value = response.result.value as? [String: String] else {
                handler(false)
                return
            }
            
            if let token = value["token"]
            {
                if token.count > 0
                {
                    let didSaveToken = BTKeychainManager.sharedManager.saveToken(token: token)
                    
                    if (didSaveToken)
                    {
                        BTUserManager.sharedManager.setUserLoginStatus(status: .LoginStatusSuccessful)
                        
                        handler(true)
                        
                        return
                    }
                }
            }
            
            handler(false)
        }
    }
    
    public func getStats(handler: @escaping ([BTUserStatsModel]?) -> Void)
    {
        guard let url = URL(string: baseURL + scoreURL) else {
            handler(nil)
            return
        }
        
        Alamofire.request(url, method: .get, parameters: ["count" : 10]).validate().responseJSON { response in
            guard response.result.isSuccess else {
                handler(nil)
                return
            }
            
            guard let values = response.result.value as? [String: Int] else {
                handler(nil)
                return
            }
            
            var array = [BTUserStatsModel]()
            
            for (score, value) in values
            {
                let stat = BTUserStatsModel.init(json: [score : value])
                
                array.append(stat)
            }
            
            handler(array)
        }
        
        return
    }
    
    public func getUserScore(handler: @escaping (BTUserStatsModel?) -> Void)
    {
        guard let url = URL(string: baseURL + myScoreURL) else {
            handler(nil)
            return
        }
        
        Alamofire.request(url, method: .get, parameters: nil).validate().responseJSON { response in
            guard response.result.isSuccess else {
                handler(nil)
                return
            }
            
            guard let value = response.result.value as? [String: Int] else {
                handler(nil)
                return
            }
            
            let stat = BTUserStatsModel.init(json: value)
            
            handler(stat)
        }
        
        return
    }
    
    public func sendSamples(force : Bool)
    {
        if force == false
        {
            let elapsed = Date().timeIntervalSince(self.lastSend!)
            
            NSLog(String(elapsed.secondsFromTimeInterval()), "")
            
            if elapsed > 30
            {
                NSLog("Sending Sample!", "")
                
                self.sendSample()
                
                self.lastSend = Date()
            }
        }
        else
        {
            NSLog("Sending forced Sample!", "")
            
            self.sendSample()
            
            self.lastSend = Date()
        }
    }
    
    public func sendSample()
    {
        guard let url = URL(string: baseURL + saveURL) else {
            return
        }
        
        Alamofire.request(url, method: .post, parameters: nil)
            .validate(contentType: ["application/json"])
            .responseJSON { response in
            guard response.result.isSuccess else {
                return
            }
            
            guard let values = response.result.value as? [String: Int] else {
                return
            }
                
            let sampleResult = BTUserSampleResultModel.init(json: values)
        }
    }
    
    class func getStats()
    {
        
    }
}

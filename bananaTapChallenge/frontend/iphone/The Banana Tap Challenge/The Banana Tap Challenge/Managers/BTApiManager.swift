//
//  BTApiManager.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 23/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit
import Alamofire

class BTApiManager: NSObject
{
    static let sharedManager = BTApiManager()
    
    private var lastSend : Date?

    private override init()
    {
        super.init()
        
        lastSend = Date()
    }
    
    public func registerUser()
    {
        // TODO: Send token request
        
        let token = BTUserRegisterResultModel.init()
        token.token = "token"
        
        let didSaveToken = BTKeychainManager.sharedManager.saveToken(token: token.token)
        
        if (didSaveToken)
        {
            BTUserManager.sharedManager.setUserLoginStatus(status: .LoginStatusSuccessful)
        }
    }
    
    public func getStats() -> [BTUserStatsModel]
    {
        // TODO: Send stats request
        
        var array = [BTUserStatsModel]()
        
        for i in 1...5
        {
            let statsDummy = BTUserStatsModel.init()
            
            statsDummy.name = "User" + i.toString()
            statsDummy.totalScore = 200 * i
            
            array.append(statsDummy)
        }
        
        return array
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
                
                // TODO: Send sample request
                
                self.lastSend = Date()
            }
        }
        else
        {
            NSLog("Sending forced Sample!", "")

            // TODO: Send sample request
            
            self.lastSend = Date()
        }
    }
    
    class func getStats()
    {
        
    }
}

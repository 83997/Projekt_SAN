//
//  BTUserManager.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 24/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit

class BTUserManager: NSObject
{
    private var userToken : String?
    private var userName : String?
    private var score : Int64 = 0
    private var taps : Int64 = 0
    private var loginStatus : BTLoginStatus = .LoginStatusNotLoggedIn
    private var lastTap : Date?
    
    static let sharedManager = BTUserManager()
    
    private override init()
    {
        super.init()
        
        if BTKeychainManager.sharedManager.getToken().count > 0
        {
            self.loginStatus = .LoginStatusSuccessful
        }
        else
        {
            self.loginStatus = .LoginStatusNotLoggedIn
        }
    }
    
    public func setUserLoginStatus(status : BTLoginStatus)
    {
        self.loginStatus = status
    }
    
    public func setUserName(name : String)
    {
        self.userName = name
    }
    
    public func setScore(score: Int64)
    {
        self.score = score
    }
    
    public func registerTap()
    {
        self.taps += 1
        
        if let lastTap = self.lastTap
        {
            let elapsed = Date().timeIntervalSince(lastTap)
            let seconds = elapsed.secondsFromTimeInterval()
            
            let force = seconds > 0
            
            BTApiManager.sharedManager.sendSamples(force: force)
        }
        
        self.lastTap = Date()
    }
    
    public func getUserLoginStatus() -> BTLoginStatus
    {
        return self.loginStatus
    }
    
    public func getUserName() -> String?
    {
        return self.userName
    }
    
    public func getScore() -> Int64
    {
        return self.score
    }
    
    public func currentTaps() -> Int64
    {
        return self.taps
    }
    
    public func resetTaps()
    {
        self.taps = 0
    }
    
    public func resetUserPoints()
    {
        self.score = 0
        self.taps = 0
    }
}

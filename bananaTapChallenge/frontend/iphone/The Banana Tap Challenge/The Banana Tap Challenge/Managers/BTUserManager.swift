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
    private var userPoints : String?
    private var loginStatus : BTLoginStatus = .LoginStatusNotLoggedIn
    
    static let sharedManager = BTUserManager()
    
    private override init()
    {
        self.userPoints = "0";
    }
    
    public func setUserLoginStatus(status : BTLoginStatus)
    {
        self.loginStatus = status
    }
    
    public func setUserName(name : String)
    {
        self.userName = name
    }
    
    public func setUserPoints(points : String)
    {
        self.userPoints = points
    }
    
    public func getUserLoginStatus() -> BTLoginStatus
    {
        return self.loginStatus
    }
    
    public func getUserName() -> String?
    {
        return self.userName
    }
    
    public func getUserPoints() -> String
    {
        return self.userPoints!
    }
    
    public func resetUserPoints()
    {
        self.userPoints = "0"
    }
}

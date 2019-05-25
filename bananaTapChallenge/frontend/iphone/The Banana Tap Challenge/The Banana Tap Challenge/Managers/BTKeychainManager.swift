//
//  BTKeychainManager.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 24/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit
import SwiftKeychainWrapper

class BTKeychainManager: NSObject
{
    static let sharedManager = BTKeychainManager()
       
    private override init()
    {
        super.init()
    }
    
    public func saveToken(token : String?) -> Bool
    {
        if let token = token
        {
            return KeychainWrapper.standard.set(token, forKey: "token")
        }
        else
        {
            return false
        }
    }
    
    public func getToken() -> String
    {
        if let token = KeychainWrapper.standard.string(forKey: "token")
        {
            return token
        }
        else
        {
            return ""
        }
    }
}


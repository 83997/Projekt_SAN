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
        lastSend = Date()
    }
    
    public func registerUser()
    {
        // TODO: Send token request
    }
    
    public func getStats()
    {
        // TODO: Send stats request
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
}

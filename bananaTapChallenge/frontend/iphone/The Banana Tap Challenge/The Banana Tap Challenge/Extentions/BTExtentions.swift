//
//  BTExtentions.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 24/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import Foundation

extension TimeInterval
{
    func stringFromTimeInterval() -> String
    {
        let time = NSInteger(self)
        
        let ms = Int((self.truncatingRemainder(dividingBy: 1)) * 1000)
        let seconds = time % 60
        let minutes = (time / 60) % 60
        let hours = (time / 3600)
        
        return String(format: "%0.2d:%0.2d:%0.2d.%0.3d",hours,minutes,seconds,ms)
    }
    
    func secondsFromTimeInterval() -> Int
    {
        let time = NSInteger(self)
        
        return time
    }
}

extension Int
{
    func toString() -> String
    {
        return String(self);
    }
}

extension Int64
{
    func toString() -> String
    {
        return String(self);
    }
}

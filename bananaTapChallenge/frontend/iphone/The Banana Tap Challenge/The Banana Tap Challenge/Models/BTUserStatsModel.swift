//
//  BTUserStatsModel.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 24/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit

class BTUserStatsModel: NSObject
{
    var name : String?
    var totalScore : Int?
    
    private override init() {}
    
    init(json : [String : Any?])
    {
        self.name = json["name"] as? String
        self.totalScore = json["totalScore"] as? Int
    }
}

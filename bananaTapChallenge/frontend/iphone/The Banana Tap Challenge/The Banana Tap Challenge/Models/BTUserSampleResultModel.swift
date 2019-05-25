//
//  BTUserSampleResultModel.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 24/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit

class BTUserSampleResultModel: NSObject
{
    var token : String?
    var ocurredOn : String?
    var finishedOn : String?
    var count : Int?

    private override init() {}
    
    init(json : [String : Any?])
    {
        self.token = json["token"] as? String
        self.ocurredOn = json["ocurredOn"] as? String
        self.finishedOn = json["finishedOn"] as? String
        self.count = json["count"] as? Int
    }
}

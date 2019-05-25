//
//  BTAlert.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 25/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit

class BTAlert: NSObject
{
    class func showErrorMessage(message : String, sourceViewController : UIViewController)
    {
        let alert = UIAlertController(title: "Error", message: message, preferredStyle: .alert)
        
        alert.addAction(UIAlertAction(title: "OK", style: .default, handler: nil))
        
        sourceViewController.present(alert, animated: true)
    }
}

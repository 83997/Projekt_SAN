//
//  BTGameViewController.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 28/04/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit

class BTGameViewController: UIViewController
{
    @IBOutlet weak var statsButton: UIButton!
    @IBOutlet weak var pointLabel: UILabel!
    @IBOutlet weak var bananaButton: UIButton!
    
    var bananaFrame : CGRect = CGRect.zero
    var pointsFrame : CGRect = CGRect.zero
    var points : Int = 0

    @IBAction func bananaTapStarted(_ sender: UIButton)
    {
        UIView.animate(withDuration: 0.05, delay: 0.0, options: .curveLinear, animations: {
            var frame = self.bananaFrame;
            
            frame.size.height *= 1.2
            frame.size.width *= 1.2
            
            frame.origin.x -= sender.frame.size.width * 0.1
            frame.origin.y -= sender.frame.size.height * 0.1
            
            self.bananaButton.frame = frame
            
        },completion: { finish in
            self.bananaButton.frame = self.bananaFrame
        })
    }
    
    @IBAction func bananaTapEnded(_ sender: UIButton)
    {
        bananaButton.frame = self.bananaFrame
        
        self.addPoint();
    }
    
    @IBAction func statsButtonTapped(_ sender: UIButton)
    {

    }
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        
        self.pointLabel.isHidden = true
    }
    
    override func viewDidAppear(_ animated: Bool)
    {
        super.viewDidAppear(animated)
        
        self.pointsFrame = self.pointLabel.frame
        self.bananaFrame = self.bananaButton.frame
        
        self.performSegue(withIdentifier: "showLoginScreen", sender: nil)
    }
    
    private func addPoint()
    {
        self.points += 1
        
        self.pointLabel.text = String(self.points)
        
        self.animatePoints()
    }
    
    private func animatePoints()
    {
        if (self.pointLabel.isHidden)
        {
            self.pointLabel.isHidden = false
        }
        self.pointLabel.frame.origin.y = (self.view.bounds.size.height / 2) - (self.pointsFrame.size.height / 2)
        
        UIView.animate(withDuration: 0.5, delay: 0.0, options: .curveLinear, animations: {
            
            self.pointLabel.frame = self.pointsFrame
            
        },completion: { finish in
            
        })
    }
}


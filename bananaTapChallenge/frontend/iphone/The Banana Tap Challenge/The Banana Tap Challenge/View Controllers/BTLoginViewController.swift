//
//  BTLoginViewController.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 23/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit
import TPKeyboardAvoiding

class BTLoginViewController: UIViewController, UITextFieldDelegate
{
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var usedNameMessageLabel: UILabel!
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var nextButton: UIButton!
    @IBOutlet weak var contentScrollView: TPKeyboardAvoidingScrollView!
    
    @IBAction func nextButtonTapped(_ sender: UIButton)
    {
        BTApiManager.sharedManager.registerUser()
        
        self.dismiss(animated: true, completion: nil)
    }
    
    override func viewDidLoad()
    {
        super.viewDidLoad()

        self.setUpViews()
        
        self.nameTextField.delegate = self
        
        self.usedNameMessageLabel.isHidden = true
    }
    
    override func viewDidAppear(_ animated: Bool)
    {
        super.viewDidAppear(animated)
        
        self.contentScrollView.contentSize = self.view.bounds.size
    }
    
    private func setUpViews()
    {
        self.nameTextField.layer.masksToBounds = true;
        self.nameTextField.layer.borderColor = UIColor.darkGray.cgColor
        self.nameTextField.backgroundColor = UIColor.lightGray
        self.nameTextField.layer.borderWidth = 5.0;
        self.nameTextField.tintColor = UIColor.red
        
        self.nextButton.layer.masksToBounds = true;
        self.nextButton.layer.borderColor = UIColor(red: 67/255.0, green: 111/255.0, blue: 0/255.0, alpha: 1.0).cgColor
        self.nextButton.layer.borderWidth = 5.0;
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool
    {
        textField.resignFirstResponder()
        
        return true
    }
}

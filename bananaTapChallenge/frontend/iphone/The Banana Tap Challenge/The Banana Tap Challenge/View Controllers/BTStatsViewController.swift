//
//  BTStatsViewController.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 24/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit

class BTStatsViewController: UIViewController, UITableViewDelegate, UITableViewDataSource
{
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var scoreTitleLabel: UILabel!
    @IBOutlet weak var scoreLabel: UILabel!
    @IBOutlet weak var backButton: UIButton!
    
    var users = 1;
    
    @IBAction func backButtonTapped(_ sender: Any)
    {
        self.dismiss(animated: true, completion: nil)
    }
    
    override func viewDidLoad()
    {
        super.viewDidLoad()

        self.tableView.delegate = self
        self.tableView.dataSource = self
        
        self.tableView.register(UINib.init(nibName: "BTStatsTableViewCell", bundle: nil), forCellReuseIdentifier: "cell")
        
        self.tableView.tableFooterView = UIView.init(frame: CGRect.zero)
        self.tableView.separatorStyle = .none
        
        self.tableView.backgroundColor = .clear
    }
    
    // MARK: - UITableView methods
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int
    {
        return 5
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell
    {
        var cell = tableView.dequeueReusableCell(withIdentifier: "cell") as? BTStatsTableViewCell
        
        if (cell != nil)
        {
            cell!.numberLabel.text = String(self.users)
            cell!.nameLabel.text = "User"
            cell!.pointsLabel.text = String(100 * self.users)
        }
        else
        {
            cell = BTStatsTableViewCell.init()
        }
        
        return cell!
    }
}

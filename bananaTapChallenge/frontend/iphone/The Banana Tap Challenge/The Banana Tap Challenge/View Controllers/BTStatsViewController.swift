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
    
    var stats : [BTUserStatsModel]?
    var activityIndicator : UIActivityIndicatorView?
    
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
        
        self.activityIndicator = UIActivityIndicatorView.init(frame: self.view.bounds)
        self.view.addSubview(self.activityIndicator!)
        
        self.setUpScore()
    }
    
    // MARK: - UITableView methods
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int
    {
        if let stats = self.stats
        {
            return stats.count
        }
        else
        {
            return 0
        }
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell
    {
        var cell = tableView.dequeueReusableCell(withIdentifier: "cell") as? BTStatsTableViewCell
        
        if (cell != nil)
        {
            cell!.numberLabel.text = (indexPath.row + 1).toString()
            cell!.nameLabel.text = self.stats![indexPath.row].name
            cell!.pointsLabel.text = self.stats![indexPath.row].totalScore?.toString()
        }
        else
        {
            cell = BTStatsTableViewCell.init()
        }
        
        return cell!
    }
    
    // MARK: - Private methods
    
    private func setUpScore()
    {
        self.activityIndicator?.startAnimating()
        
        self.stats = BTApiManager.sharedManager.getStats()

        self.scoreLabel.text = BTUserManager.sharedManager.getUserPoints().toString()
        
        self.tableView.reloadData()
        
        self.activityIndicator?.stopAnimating()
    }
}

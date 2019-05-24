//
//  BTStatsTableViewCell.swift
//  The Banana Tap Challenge
//
//  Created by Sebastian Gnas on 24/05/2019.
//  Copyright © 2019 Sebastian Gnas. All rights reserved.
//

import UIKit

class BTStatsTableViewCell: UITableViewCell {

    @IBOutlet weak var numberLabel: UILabel!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var pointsLabel: UILabel!
    
    override func awakeFromNib()
    {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool)
    {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}

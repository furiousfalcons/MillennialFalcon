/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.opencv.core.Rect;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class AutoAssist extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public boolean isEnabled = false;
  
  public ArrayList<Integer> leftRectAlignment;
  public ArrayList<Integer> rightRectAlignment;

  public Rect rectLeft, rectRight;

  public AutoAssist() {
    findBetweenValues(leftRectAlignment, 210, 235);
    findBetweenValues(rightRectAlignment, 420, 455);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void autoAssist() {

    //add angled autoAssist code here
    
    while ( (!leftRectAlignment.contains(rectLeft.x)) || (!rightRectAlignment.contains(rectRight.x)) ) {
      if (rectLeft.x < leftRectAlignment.get(0)) {
        //move right
        Robot.driveTrain.autoNormalDrive(0, 1, 0);
        try {
          TimeUnit.SECONDS.sleep(Double.doubleToLongBits(0.1));
        } catch (Exception e) {
          System.out.println("Failed to delay for AutoAssist-MoveRight time");
        }
      } else if (rectLeft.x > leftRectAlignment.get(leftRectAlignment.size())) {
        //move left
        Robot.driveTrain.autoNormalDrive(0, -1, 0);
        try {
          TimeUnit.SECONDS.sleep(Double.doubleToLongBits(0.1));
        } catch (Exception e) {
          System.out.println("Failed to delay for AutoAssist-MoveLeft time");
        }
      } else {
        //should stop while loop
      }
    }

  }

  public void enableAutoAssist() {
    isEnabled = true;
    Robot.dashComms.entryIsAutoAssist.setBoolean(true);
    autoAssist();
  }

  public void disableAutoAssist() {
    isEnabled = false;
    Robot.dashComms.entryIsAutoAssist.setBoolean(false);
  }

  public void findBetweenValues(ArrayList<Integer> list, int start, int end) {
    list = new ArrayList<Integer>();
    for (int i = start; i <= end; i++) {
      list.add(i);
    }
  }

}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

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

  public Rect rectLeft;
  public Rect rectRight;

  public AutoAssist() {
    findLeftValues(210, 235);
    findRightValues(420, 455);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void autoAssist() {
    //autoassist stuff
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

  public void findLeftValues(int start, int end) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = start; i <= end; i++) {
      list.add(i);
    }
    leftRectAlignment = list;
  }

  public void findRightValues(int start, int end) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = start; i <= end; i++) {
      list.add(i);
    }
    rightRectAlignment = list;
  }

}

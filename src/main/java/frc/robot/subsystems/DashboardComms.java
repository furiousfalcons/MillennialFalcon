/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.ComplexWidget;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;

/**
 * Add your docs here.
 */
public class DashboardComms extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public ShuffleboardTab tab;
  public ComplexWidget cameraView;
  public ComplexWidget visionView;
  public SimpleWidget isVisionTargets;
  public SimpleWidget isAutoAssist;
  public SimpleWidget throttle;
  public NetworkTableEntry entryIsVisionTargets;
  public NetworkTableEntry entryIsAutoAssist;
  public NetworkTableEntry entryLFMotor;
  public NetworkTableEntry entryLBMotor;
  public NetworkTableEntry entryRFMotor;
  public NetworkTableEntry entryRBMotor;
  public NetworkTableEntry entryThrottle;

  public DashboardComms() {
    initDashboard();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand()); 
  }

  public void initDashboard() {
    tab = Shuffleboard.getTab("MillennialFalconDashboard");
    isVisionTargets = tab.add("Falcon Vision Targets Found", false);
    isVisionTargets.withPosition(2, 1);
    isVisionTargets.withSize(2, 1);
    entryIsVisionTargets = isVisionTargets.getEntry();
    isAutoAssist = tab.add("Falcon Auto Assist", false);
    isAutoAssist.withPosition(2, 2);
    isVisionTargets.withSize(2, 1);
    entryIsAutoAssist = isAutoAssist.getEntry();
    /*entryLFMotor = tab.add("Left Front Motor", 0.0).getEntry();
    entryLBMotor = tab.add("Left Back Motor", 0.0).getEntry();
    entryRFMotor = tab.add("Right Front Motor", 0.0).getEntry();
    entryRBMotor = tab.add("Right Back Motor", 0.0).getEntry();*/
    throttle = tab.add("Throttle", 50);
    throttle.withPosition(8, 1);
    throttle.withSize(2, 2);
    throttle.withWidget("Simple Dial");
    entryThrottle = throttle.getEntry();
    //visionView = tab.add("Falcon Vision Target Locator", idk);
  }
}

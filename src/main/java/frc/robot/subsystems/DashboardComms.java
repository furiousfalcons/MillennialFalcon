/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.*;

/**
 * Add your docs here.
 */
public class DashboardComms extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public ShuffleboardTab tab;
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
    entryIsVisionTargets = tab.add("Falcon Vision Targets Found", false).getEntry();
    entryIsAutoAssist = tab.add("Falcon Auto Assist", false).getEntry();
    entryLFMotor = tab.add("Left Front Motor", 0.0).getEntry();
    entryLBMotor = tab.add("Left Back Motor", 0.0).getEntry();
    entryRFMotor = tab.add("Right Front Motor", 0.0).getEntry();
    entryRBMotor = tab.add("Right Back Motor", 0.0).getEntry();
    entryThrottle = tab.add("Throttle", 50).getEntry();
  }
}

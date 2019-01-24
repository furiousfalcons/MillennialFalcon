/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.Robot;
import frc.robot.commands.NormalDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static MecanumDrive drive = new MecanumDrive(RobotMap.LFMotor, RobotMap.LBMotor, RobotMap.RFMotor, RobotMap.RBMotor);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new NormalDrive());
  }
  public void normalDrive() {
    drive.driveCartesian(-Robot.oi.controller1.getRawAxis(1), Robot.oi.controller1.getRawAxis(0), Robot.oi.controller1.getRawAxis(4));
  }
}

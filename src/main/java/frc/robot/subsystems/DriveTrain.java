/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.MecaDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;




/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
 
 
  public static MecanumDrive kill = new MecanumDrive(RobotMap.frontLeftMotor, RobotMap.frontRightMotor, RobotMap.backLeftMotor, RobotMap.backRightMotor);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MecaDrive());
  }
  public void mecaDrive() {
    kill.driveCartesian(Robot.oi.xbox.getRawAxis(0) / 2, Robot.oi.xbox.getRawAxis(1) / 2, Robot.oi.xbox.getRawAxis(4));
  }
  public void stop() {
    RobotMap.driveTrain.driveCartesian(0.0, 0.0, 0.0);

  }
  public void slowDrive() {
    kill.driveCartesian(-Robot.oi.xbox.getRawAxis(1), Robot.oi.xbox.getRawAxis(0), Robot.oi.xbox.getRawAxis(4));
  }
}

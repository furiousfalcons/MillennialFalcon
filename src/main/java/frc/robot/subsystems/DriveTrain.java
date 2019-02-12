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

  public MecanumDrive drive = new MecanumDrive(RobotMap.LFMotor, RobotMap.LBMotor, RobotMap.RFMotor,
      RobotMap.RBMotor);

  public boolean isManualEnabled = true;
  
  public double throttle = .5;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new NormalDrive());
  }

  public void normalDrive() {
    if (isManualEnabled) {
      drive.driveCartesian(Robot.oi.controller1.getRawAxis(0) * throttle, -Robot.oi.controller1.getRawAxis(1) * throttle,
            Robot.oi.controller1.getRawAxis(4));
    }
  }

  public void stopDrive() {
    drive.driveCartesian(0, 0, 0);
  }

  public void toggleEnabled() {
    isManualEnabled = !isManualEnabled;
  }

  public void disableDrive() {
    isManualEnabled = false;
  }

  public void enableDrive() {
    isManualEnabled = true;
  }

  public void incThrottle() {
    double percent = throttle * 100;
    percent += 1;
    throttle = percent / 100;
    Robot.dashComms.entryThrottle.setDouble(percent);
  }

  public void decThrottle() {
    double percent = throttle * 100;
    percent -= 1;
    throttle = percent / 100;
    Robot.dashComms.entryThrottle.setDouble(percent);
  }

  public void autoNormalDrive(double ySpeed, double xSpeed, double zSpeed) {
    drive.driveCartesian(ySpeed, xSpeed, zSpeed);
  }

}

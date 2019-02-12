/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class EnableAutoAssist extends Command {
  public EnableAutoAssist() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.visionControl);
    requires(Robot.driveTrain);
    requires(Robot.panelManipulation);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.dashComms.entryIsAutoAssist.setBoolean(true);
    Robot.driveTrain.disableDrive();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    ArrayList<Double> values = Robot.visionControl.getCenters();
    double centerXLeft = values.get(0);
    double centerYLeft = values.get(1);
    double centerXRight = values.get(2);
    double centerYRight = values.get(3);

    System.out.println(centerXLeft);
    System.out.println(centerYLeft);
    System.out.println(centerXRight);
    System.out.println(centerYRight);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.dashComms.entryIsAutoAssist.setBoolean(false);
    Robot.driveTrain.enableDrive();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}

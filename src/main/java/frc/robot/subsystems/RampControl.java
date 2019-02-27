/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.RampGo;
import frc.robot.RobotMap;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class RampControl extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public SpeedControllerGroup motors = RobotMap.rampMotors;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new RampGo());
  }

  public void checkAndGo() {
    if (Robot.oi.controller1.getRawAxis(3) > 0) {
      motors.set(1);
    } else if (Robot.oi.controller1.getRawAxis(2) > 0) {
      motors.set(-1);
    } else {
      motors.set(0);
    }
  }

}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PanelManipulation extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public boolean isEnabled = true;

  public SpeedController extenderActuator = RobotMap.PanelExtenderActuator;
  public SpeedController attatcherActuators = RobotMap.PanelAttacherActuators;
  public SpeedController elevationActuator = RobotMap.PanelElevationAcutator;

  public double extenderActuatorSpeed = 2.098;

  public boolean attatcherAcuatorsOut = false;

  public PanelManipulation() {
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void togglePanel() {
    if (isEnabled) {
      if (attatcherAcuatorsOut) {
        attatcherActuators.set(1);
        Robot.dashComms.entryisGrabber.setBoolean(false);
      } else {
        attatcherActuators.set(0);
        Robot.dashComms.entryisGrabber.setBoolean(true);
      }

      attatcherAcuatorsOut = !attatcherAcuatorsOut;
    }
  }

  public void setEnabled() {
    isEnabled = true;
  }

  public void setDisabled() {
    isEnabled = false;
  }
}

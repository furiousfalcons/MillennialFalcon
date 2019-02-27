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

  public boolean attatcherAcuatorsOut = true;

  public PanelManipulation() {
    togglePanel();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void elevateArmUp() {
    if (isEnabled) {
      elevationActuator.set(-1);
    }
  }

  public void elevateArmDown() {
    if (isEnabled) {
      elevationActuator.set(1);
    }
  }

  public void elevateArmStop() {
    if (isEnabled) {
      elevationActuator.set(0);
    }

  }

  public void extendArm() {
    if (isEnabled) {
      extenderActuator.set(1);
    }
  }

  public void extendStopArm() {
    if (isEnabled) {
      extenderActuator.stopMotor();
    }
  }

  public void contractArm() {
    if (isEnabled) {
      extenderActuator.set(-1);
    }
  }

  public void extendArmFor(double time) {
    extendArm();
    try {
      TimeUnit.SECONDS.sleep(Double.doubleToLongBits(time));
    } catch (Exception e) {
      System.out.println("Failed to delay for extendArmFor time");
    }
    extendStopArm();
  }

  public void contractArmFor(double time) {
    contractArm();
    try {
      TimeUnit.SECONDS.sleep(Double.doubleToLongBits(time));
    } catch (Exception e) {
      System.out.println("Failed to delay for contractArmFor time");
    }
    extendStopArm();
  }

  public void extendArmTo(double distance) { // distance in inches
    extendArmFor((distance / extenderActuatorSpeed));
  }

  public void contractArmTo(double distance) { // distance in inches
    contractArmFor((distance / extenderActuatorSpeed));
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

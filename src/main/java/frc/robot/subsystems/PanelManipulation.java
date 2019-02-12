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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PanelManipulation extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static SpeedController extenderActuator = RobotMap.PanelExtenderActuator;
  public static SpeedController attatcherActuators = RobotMap.PanelAttacherActuators;

  public static double extenderActuatorSpeed = 2.098;

  public PanelManipulation() {
    togglePanel();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void extendArm() {
    extenderActuator.set(1);
  }

  public void stopArm() {
    extenderActuator.stopMotor();
  }

  public void contractArm() {
    extenderActuator.set(-1);
  }

  public void extendArmFor(double time) {
    extendArm();
    try {
      TimeUnit.SECONDS.sleep(Double.doubleToLongBits(time));
    } catch (Exception e) {
      System.out.println("Failed to delay for extendArmFor time");
    }
    stopArm();
  }

  public void contractArmFor(double time) {
    contractArm();
    try {
      TimeUnit.SECONDS.sleep(Double.doubleToLongBits(time));
    } catch (Exception e) {
      System.out.println("Failed to delay for contractArmFor time");
    }
    stopArm();
  }

  public void extendArmTo(double distance) { //distance in inches
    extendArmFor((distance / extenderActuatorSpeed));
  }

  public void contractArmTo(double distance) { //distance in inches
    contractArmFor((distance / extenderActuatorSpeed));
  }

  public void togglePanel() {
    double i = attatcherActuators.get();
    if (i == 1) {
      attatcherActuators.set(0);
    } else {
      attatcherActuators.set(1);
    }
  }
}

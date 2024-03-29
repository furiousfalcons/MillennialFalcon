/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static SpeedController LFMotor; //left front motor
  public static SpeedController LBMotor; //left back motor
  public static SpeedController RFMotor; //right front motor
  public static SpeedController RBMotor; //right back motor

  public static SpeedController PanelExtenderActuator; //actuator for extending the panel arm
  public static SpeedController PanelAttacherActuators; //mini actuators for grabbing or attaching to the panel
  public static SpeedController PanelElevationAcutator; //actuator for lifting the arm

  public static SpeedController rampMotors1;
  public static SpeedController rampMotors2;

  public static SpeedControllerGroup rampMotors;
  

  public static void init() {
    //PWM
    LFMotor = new Spark(0); //port0
    LBMotor = new Spark(1); //port1
    RFMotor = new Spark(2); //port2
    RBMotor = new Spark(3); //port3

    PanelExtenderActuator = new Spark(4); //port 4
    PanelAttacherActuators = new Spark(5); //port 5
    PanelElevationAcutator = new Spark(6); //port 6

    rampMotors1 = new Spark(7);
    rampMotors2 = new Spark(8);

    rampMotors = new SpeedControllerGroup(rampMotors1, rampMotors2);
    
    //DIO

    //Analog

  }
}

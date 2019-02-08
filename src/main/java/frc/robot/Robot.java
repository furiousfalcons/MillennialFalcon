/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PanelManipulation;
import frc.robot.subsystems.VisionControl;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;
  
  public static DriveTrain driveTrain;
  public static VisionControl visionControl;
  public static PanelManipulation panelManipulation;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    startUp();

   RobotMap.init();

   driveTrain = new DriveTrain();
   visionControl = new VisionControl();
   panelManipulation = new PanelManipulation();

   oi = new OI();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
 
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public void startUp() {
    System.out.println("\r\n__/\\\\\\\\____________/\\\\\\\\________/\\\\\\\\\\\\_____/\\\\\\\\\\\\_____________________________________________________________________/\\\\\\\\\\\\____                 \r\n _\\/\\\\\\\\\\\\________/\\\\\\\\\\\\_______\\////\\\\\\____\\////\\\\\\____________________________________________________________________\\////\\\\\\____                \r\n  _\\/\\\\\\//\\\\\\____/\\\\\\//\\\\\\__/\\\\\\____\\/\\\\\\_______\\/\\\\\\________________________________________________/\\\\\\___________________\\/\\\\\\____               \r\n   _\\/\\\\\\\\///\\\\\\/\\\\\\/_\\/\\\\\\_\\///_____\\/\\\\\\_______\\/\\\\\\________/\\\\\\\\\\\\\\\\___/\\\\/\\\\\\\\\\\\____/\\\\/\\\\\\\\\\\\___\\///___/\\\\\\\\\\\\\\\\\\_______\\/\\\\\\____              \r\n    _\\/\\\\\\__\\///\\\\\\/___\\/\\\\\\__/\\\\\\____\\/\\\\\\_______\\/\\\\\\______/\\\\\\/////\\\\\\_\\/\\\\\\////\\\\\\__\\/\\\\\\////\\\\\\___/\\\\\\_\\////////\\\\\\______\\/\\\\\\____             \r\n     _\\/\\\\\\____\\///_____\\/\\\\\\_\\/\\\\\\____\\/\\\\\\_______\\/\\\\\\_____/\\\\\\\\\\\\\\\\\\\\\\__\\/\\\\\\__\\//\\\\\\_\\/\\\\\\__\\//\\\\\\_\\/\\\\\\___/\\\\\\\\\\\\\\\\\\\\_____\\/\\\\\\____            \r\n      _\\/\\\\\\_____________\\/\\\\\\_\\/\\\\\\____\\/\\\\\\_______\\/\\\\\\____\\//\\\\///////___\\/\\\\\\___\\/\\\\\\_\\/\\\\\\___\\/\\\\\\_\\/\\\\\\__/\\\\\\/////\\\\\\_____\\/\\\\\\____           \r\n       _\\/\\\\\\_____________\\/\\\\\\_\\/\\\\\\__/\\\\\\\\\\\\\\\\\\__/\\\\\\\\\\\\\\\\\\__\\//\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\___\\/\\\\\\_\\/\\\\\\___\\/\\\\\\_\\/\\\\\\_\\//\\\\\\\\\\\\\\\\/\\\\__/\\\\\\\\\\\\\\\\\\_          \r\n        _\\///______________\\///__\\///__\\/////////__\\/////////____\\//////////__\\///____\\///__\\///____\\///__\\///___\\////////\\//__\\/////////__         \r\n ________________________________/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\_________________/\\\\\\\\\\\\__________________________________________________________________         \r\n  _______________________________\\/\\\\\\///////////_________________\\////\\\\\\__________________________________________________________________        \r\n   _______________________________\\/\\\\\\_______________________________\\/\\\\\\__________________________________________________________________       \r\n    _______________________________\\/\\\\\\\\\\\\\\\\\\\\\\______/\\\\\\\\\\\\\\\\\\_______\\/\\\\\\________/\\\\\\\\\\\\\\\\_____/\\\\\\\\\\_____/\\\\/\\\\\\\\\\\\_______________________      \r\n     _______________________________\\/\\\\\\///////______\\////////\\\\\\______\\/\\\\\\______/\\\\\\//////____/\\\\\\///\\\\\\__\\/\\\\\\////\\\\\\______________________     \r\n      _______________________________\\/\\\\\\_______________/\\\\\\\\\\\\\\\\\\\\_____\\/\\\\\\_____/\\\\\\__________/\\\\\\__\\//\\\\\\_\\/\\\\\\__\\//\\\\\\_____________________    \r\n       _______________________________\\/\\\\\\______________/\\\\\\/////\\\\\\_____\\/\\\\\\____\\//\\\\\\________\\//\\\\\\__/\\\\\\__\\/\\\\\\___\\/\\\\\\_____________________   \r\n        _______________________________\\/\\\\\\_____________\\//\\\\\\\\\\\\\\\\/\\\\__/\\\\\\\\\\\\\\\\\\__\\///\\\\\\\\\\\\\\\\__\\///\\\\\\\\\\/___\\/\\\\\\___\\/\\\\\\_____________________  \r\n         _______________________________\\///_______________\\////////\\//__\\/////////_____\\////////_____\\/////_____\\///____\\///______________________ \r\n ");
  }
}

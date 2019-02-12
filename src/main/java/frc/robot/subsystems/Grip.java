/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Vision;
import edu.wpi.first.wpilibj.CameraServer;


/**
 * Add your docs here.  
 */
public class Grip extends Subsystem {
  VisionThread visionThread;
  UsbCamera camera;
  Vision vision;


  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void getVision() {
    camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(640, 480);
  }
  public void stahp() {



}
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class VisionControl extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  VisionThread visionThread;
  public UsbCamera cam1;
  public UsbCamera cam2;
  public VideoSink camServer;
  public boolean camera1Active = true;

  public VisionControl() {
    initVision();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void initVision() {
    try {  // Used try catch so if one camera fails then the whole robot doesn't crash
      cam1 = CameraServer.getInstance().startAutomaticCapture(0);
    } catch (Exception e) {
      System.out.println(e.getStackTrace());
      System.err.println("Camera 1 failed, check log for error");
    }
    
    try {
      cam2 = CameraServer.getInstance().startAutomaticCapture(1);
    } catch (Exception e) {
      System.out.println(e.getStackTrace());
      System.err.println("Camera 2 failed, check log for error");
    }

    camServer = CameraServer.getInstance().getServer();

    cam1.setFPS(30); //Attempt at fixing bad camera FPS
    cam2.setFPS(30);

  }

  public void switchCameras() {
    if(camera1Active) {
      camServer.setSource(cam2);
      System.out.println("Camera switched to: Cam 2");
    }
    else {
      camServer.setSource(cam1);
      System.out.println("Camera switched to: Cam 1");
    }

    SmartDashboard.putBoolean("Primary Camera", camera1Active);
    camera1Active = !camera1Active;
  }
}

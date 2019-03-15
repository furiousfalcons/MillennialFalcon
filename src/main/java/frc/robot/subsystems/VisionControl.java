/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.VisionImplementation;

/**
 * Add your docs here.
 */
public class VisionControl extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  VisionThread visionThread;
  public UsbCamera cam;

  int camResX = 160;
  int camResY = 120;

  public Rect rectLeft, rectRight;

  public Object imgLock = new Object();

  public VisionControl() {
    try{
    initVision();
    }
    catch(Exception e){
      System.out.print(e.getStackTrace());
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void initVision() {
    CameraServer.getInstance().startAutomaticCapture();
  //   cam = CameraServer.getInstance().startAutomaticCapture();
  //   cam.setExposureManual(100);
  //   cam.setFPS(10);
  //   cam.setResolution(camResX, camResY);

  //   Robot.dashComms.cameraView = Robot.dashComms.tab.add("Falcon Cam", cam);
  //   Robot.dashComms.cameraView.withPosition(3, 0);
  //   Robot.dashComms.cameraView.withSize(4, 4);

  //   visionThread = new VisionThread(cam, new VisionImplementation(), pipeline -> {
  //     if (pipeline.filterContoursOutput().size() == 2) {
  //       Robot.dashComms.entryIsVisionTargets.setBoolean(true);
  //       Rect r1 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
  //       Rect r2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
  //       if (r1.x > r2.x) {
  //         Rect rTemp = r1;
  //         r1 = r2;
  //         r2 = rTemp;
  //       }
  //       synchronized (imgLock) {
  //         rectLeft = r1;
  //         Robot.autoAssist.rectLeft = rectLeft;
  //         rectRight = r2;
  //         Robot.autoAssist.rectRight = rectRight;
  //       }
  //     } else {
  //       Robot.dashComms.entryIsVisionTargets.setBoolean(false);
  //     }
  //   });
    
  //   visionThread.setDaemon(true);
  //   visionThread.start();
  // }

  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

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
  UsbCamera cam;

  int camResX = 640;
  int camResY = 480;

  double centerXLeft = 0.0;
  double centerYLeft = 0.0;
  double centerXRight = 0.0;
  double centerYRight = 0.0;

  Object imgLock = new Object();

  public VisionControl() {
    initVision();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void initVision() {
    cam = CameraServer.getInstance().startAutomaticCapture("Falcon Cam", 0);
    cam.setExposureManual(20);
    cam.setFPS(10);
    cam.setResolution(camResX, camResY);

    visionThread = new VisionThread(cam, new VisionImplementation(), pipeline -> {
      System.out.println(pipeline.filterContoursOutput().size());
      if (pipeline.filterContoursOutput().size() == 2) {
        Robot.dashComms.entryIsVisionTargets.setBoolean(true);
        Rect r1 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
        Rect r2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
        synchronized (imgLock) {
          centerXLeft = r1.x + (r1.width / 2);
          centerYLeft = r1.y + (r1.height / 2);
          centerXRight = r2.x + (r2.width / 2);
          centerYRight = r2.y + (r2.height / 2);
        }
      } else {
        Robot.dashComms.entryIsVisionTargets.setBoolean(false);
      }
    });

    visionThread.start();
  }

  public ArrayList<Double> getCenters() {
    ArrayList<Double> values = new ArrayList<Double>();
    values.add(centerXLeft);
    values.add(centerYLeft);
    values.add(centerXRight);
    values.add(centerYRight);
    return values;
  }

}

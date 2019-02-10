/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.VisionImplementation;
import frc.robot.commands.DisableDrive;
import frc.robot.commands.EnableDrive;
import frc.robot.commands.InitVision;

/**
 * Add your docs here.
 */
public class VisionControl extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  VisionThread visionThread;
  UsbCamera cam;
  CvSink sink;
  CvSource output;
  Mat mat;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public VisionControl() {
    InitVision initVision = new InitVision();
    initVision.close();
  }

  public void initVision() {
    cam = CameraServer.getInstance().startAutomaticCapture();
    cam.setExposureManual(20);
    cam.setResolution(640, 480);

    sink = CameraServer.getInstance().getVideo();

    output = CameraServer.getInstance().putVideo("MillennialFalconCam", 640, 480);

    visionThread = new VisionThread(cam, new VisionImplementation(), pipeline -> {
      if (!pipeline.filterContoursOutput().isEmpty()) {
        for (int i = 0; i < pipeline.filterContoursOutput().size(); i++) {
          Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(i));
          System.out.println("Rectangle #" + i + ": " + r.x + ", " + r.y + ", " + r.width + ", " + r.height);
        }
      }
    });
  }

  public void autoAssist() {
    //Disable Manual Drive
    DisableDrive disableDrive = new DisableDrive();
    disableDrive.close();



    //Re-Enable Manual Drive
    EnableDrive enableDrive = new EnableDrive();
    enableDrive.close();
  }

}

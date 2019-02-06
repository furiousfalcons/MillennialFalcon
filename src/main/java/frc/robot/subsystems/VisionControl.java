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
import frc.robot.commands.GetVision;

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
    setDefaultCommand(new GetVision());
  }

  public void getVision() {
    cam = CameraServer.getInstance().startAutomaticCapture();
    cam.setExposureManual(20);
    cam.setResolution(640, 480);

    sink = CameraServer.getInstance().getVideo();

    output = CameraServer.getInstance().putVideo("Processed: ", 640, 480);

    visionThread = new VisionThread(cam, new VisionImplementation(), pipeline -> {
      if (!pipeline.filterContoursOutput().isEmpty()) {
        Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
        System.out.println(r.x + ", " + r.y + ", " + r.width + ", " + r.height);
      }
    });
  }
}

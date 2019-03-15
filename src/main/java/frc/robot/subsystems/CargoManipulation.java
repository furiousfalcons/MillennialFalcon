/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DetectBallGrab;

/**
 * Add your docs here.
 */
public class CargoManipulation extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Compressor compressor;
  public Solenoid cylinder;

  public CargoManipulation() {
    compressor = new Compressor(0);
    cylinder = new Solenoid(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
   //  setDefaultCommand();
  }

  public void popCargo() {
    cylinder.set(true);
  }

  public void holdCargo() {
    cylinder.set(false);
  }
}

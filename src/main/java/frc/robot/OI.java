/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmIn;
import frc.robot.commands.ArmOut;
import frc.robot.commands.Fast;
import frc.robot.commands.Grab;
import frc.robot.commands.UnGrab;;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways: 

  // Start the command when the button is pressed and let it run the comfimand
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public XboxController xbox;

  public OI(){
    xbox = new XboxController(0);
    Button Fast = new JoystickButton(xbox, 8);
    Fast.whenPressed(new Fast()); 
    Fast.close();
    Button armOut = new JoystickButton(xbox,1);
    armOut.whenPressed(new ArmIn());
    armOut.close();
    Button armIn = new JoystickButton(xbox,3);
    armIn.whenPressed(new ArmOut());
    armIn.close();
    Button GraB = new JoystickButton(xbox, 4);
    GraB.whenPressed(new Grab());
    GraB.whenReleased(new UnGrab());
    GraB.close();
  }
}


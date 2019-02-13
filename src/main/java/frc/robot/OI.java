/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.GrabPanel;
import frc.robot.subsystems.HatchPanel;
import frc.robot.commands.ExtendArm;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.XboxClass;
import edu.wpi.first.hal.*;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.MecaDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
  
  public static XboxController xbox;
	public JoystickButton xButton;
	public JoystickButton yButton;
	public JoystickButton aButton;
	public JoystickButton bButton;
	public JoystickButton rightBumper; 
	public JoystickButton leftBumper; 
	public JoystickButton startButton; 
	public JoystickButton selectButton; 
	public JoystickButton leftStickButton;
	public JoystickButton rightStickButton;

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  //  button = new JoystickButton(stick, buttonNumber);
  public OI() {
    
     xbox = new XboxController(0);
     xButton = new JoystickButton(xbox, 3);
     yButton = new JoystickButton(xbox, 4); 
     aButton = new JoystickButton(xbox, 1);
     bButton = new JoystickButton(xbox, 2);
     rightBumper = new JoystickButton(xbox, 6); // hard thing
     leftBumper = new JoystickButton(xbox, 5);
     startButton = new JoystickButton(xbox, 8);
     selectButton = new JoystickButton(xbox, 7);
     leftStickButton = new JoystickButton(xbox, 9); //left toggle
     rightStickButton = new JoystickButton(xbox, 10); //right toggle
    
    //commands
    
    rightStickButton.whenPressed(new MecaDrive());
    leftStickButton.whenPressed(new GrabPanel());
    rightBumper.whenPressed(new ExtendArm());
    





    
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing  you can create custom triggers and bind those to
  // commands the same as any other .

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  }
  

}

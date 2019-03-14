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
import frc.robot.commands.DecreaseThrottle;
import frc.robot.commands.EnableAutoAssist;
import frc.robot.commands.HoldCargo;
import frc.robot.commands.IncreaseThrottle;
import frc.robot.commands.PopCargo;
import frc.robot.commands.TogglePanel;
import frc.robot.commands.ToggleReverseDrive;

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

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  
  public XboxController controller1;

  public OI() {
    controller1 = new XboxController(0);

    //Enable Auto Assist Button
    Button autoAssistButton = new JoystickButton(controller1, 1);
    autoAssistButton.whenPressed(new EnableAutoAssist());
    autoAssistButton.close();

    //Increase Throttle Button
    Button incThrottleButton = new JoystickButton(controller1, 7);
    incThrottleButton.whileHeld(new IncreaseThrottle());
    incThrottleButton.close();

    //Decrease Throttle Button
    Button decThrottleButton = new JoystickButton(controller1, 8);
    decThrottleButton.whileHeld(new DecreaseThrottle());
    decThrottleButton.close();
    
    //Manual Panel Toggle Button
    Button panelToggleButton = new JoystickButton(controller1, 2);
    panelToggleButton.whenPressed(new TogglePanel());
    panelToggleButton.close();
    
    //Ball Pop Button
    Button ballPopButton = new JoystickButton(controller1, 3);
    ballPopButton.whenPressed(new PopCargo());
    ballPopButton.whenReleased(new HoldCargo());
    ballPopButton.close();

    //Reverse DriveTrain Button
    Button reverseDTButton = new JoystickButton(controller1, 4);
    reverseDTButton.whenPressed(new ToggleReverseDrive());
    reverseDTButton.close();
    
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.hal.*;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.OI;

public class XboxClass extends Joystick {

	public XboxClass(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}
    public static XboxController xbox;
	public JoystickButton xButton = new JoystickButton(xbox, 3);
	public JoystickButton yButton = new JoystickButton(xbox, 4);
	public JoystickButton aButton = new JoystickButton(xbox, 1);
	public JoystickButton bButton = new JoystickButton(xbox, 2);
	public JoystickButton rightBumper = new JoystickButton(xbox, 6);
	public JoystickButton leftBumper = new JoystickButton(xbox, 5);
	public JoystickButton startButton = new JoystickButton(xbox, 8);
	public JoystickButton selectButton = new JoystickButton(xbox, 7);
	public JoystickButton leftStickButton = new JoystickButton(xbox, 9);
	public JoystickButton rightStickButton = new JoystickButton(xbox, 10);

	private int m_outputs;
	private short m_leftRumble;
	private short m_rightRumble;

	// public DPadUp dPadUp = new DPadUp(xbox);
	// public DPadDown dPadDown = new DPadDown(xbox);

	public double getTriggerTwist() {
		double leftTriggerValue = xbox.getRawAxis(2);
		double rightTriggerValue = -1 * xbox.getRawAxis(3);

		return leftTriggerValue + rightTriggerValue;

	}

	public double getLeftStickX() {
		return xbox.getRawAxis(0);
	}

	public double getLeftStickY() {
		return -xbox.getRawAxis(1);
	}

	public double getRightStickX() {
		return xbox.getRawAxis(4); // 4
	}

	public double getRightStickY() {
		return -xbox.getRawAxis(5);
	}

	public void setRumble(double leftValue, double rightValue) {
		setRumble(RumbleType.kLeftRumble, leftValue);
		setRumble(RumbleType.kRightRumble, rightValue);
	}

	public void setRumble(RumbleType type, double value) {
		if (value < 0) {
			value = 0;
		} else if (value > 1) {
			value = 1;
		}
		if (type == RumbleType.kLeftRumble) {
			m_leftRumble = (short) (value * 65535);
		} else {
			m_rightRumble = (short) (value * 65535);
		}
		HAL.setJoystickOutputs((byte) getPort(), m_outputs, m_leftRumble, m_rightRumble);
	}

}







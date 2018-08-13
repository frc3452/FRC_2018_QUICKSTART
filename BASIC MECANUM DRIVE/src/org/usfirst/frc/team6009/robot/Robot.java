package org.usfirst.frc.team6009.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Robot extends IterativeRobot {

	//Timer for autonomous
	Timer timer = new Timer();

	//This is where our motor controllers are initialized.
	public static Talon frontLeft = new Talon(0);
	public static Talon rearLeft = new Talon(1);
	public static Talon frontRight = new Talon(2);
	public static Talon rearRight = new Talon(3);

	
	//Initialize joystick in port 0
	public static Joystick joy = new Joystick(0);

	//Make the Mecanum drive
	public static MecanumDrive robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

	@Override
	public void robotInit() {
		timer.stop();
		timer.reset();
		timer.start();
		//PROPER WAY TO RESET TIMER ^^^^^^

		
		//Set appropriate motor inverts
		//DO NOT TOUCH UNLESS REWIRING
		frontLeft.setInverted(false);
		rearLeft.setInverted(true);
		rearRight.setInverted(false);
		frontRight.setInverted(true);	
	}

	@Override
	public void autonomousInit() {
		timer.stop();
		timer.reset();
		timer.start();
		//Reset timer for autonomous
		
	}

	@Override
	public void autonomousPeriodic() {
		//For 5 seconds drive forward at 25 percent
		if (timer.get() < 5) {
			robotDrive.driveCartesian(.25, 0, 0);
		} else {
			//Then stop
			robotDrive.driveCartesian(0, 0, 0);
		}

	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		//Drive in tele.
		robotDrive.driveCartesian(-joy.getRawAxis(1), joy.getRawAxis(4), joy.getRawAxis(0));
	}
}

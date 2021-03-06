package org.usfirst.frc.team5066.controller2017.controlSchemes;

import org.usfirst.frc.team5066.controller2017.ControlScheme;
import org.usfirst.frc.team5066.controller2017.XboxController;
import org.usfirst.frc.team5066.library.SingularityDrive;
import org.usfirst.frc.team5066.library.SpeedMode;
import org.usfirst.frc.team5066.robot.LowGoalShooter;
import org.usfirst.frc.team5066.robot.SingularityClimber;
import org.usfirst.frc.team5066.robot.SingularityIntake;


public class OneController implements ControlScheme {
	
	XboxController xbox;
	SpeedMode speedMode;
	boolean on, prevY;
	
	public OneController(int xboxPort) {
		xbox = new XboxController(xboxPort);
	}
	
	@Override
	public void drive(SingularityDrive sd, boolean squaredInputs) {
		//set speedMode
		if(xbox.getLB()) {
			speedMode = SpeedMode.SLOW;
		} else if(xbox.getRB()) {
			speedMode = SpeedMode.FAST;
		} else {
			speedMode = SpeedMode.NORMAL;
		}
		
		sd.hDrive(xbox.getLS_Y(), xbox.getLS_X(), xbox.getRS_X(), squaredInputs, speedMode);

	}

	@Override
	public void controlShooter(LowGoalShooter lGS) {
		lGS.setSpeed(xbox.getTriggerRight() > 0.3);
	}

	@Override
	public void controlClimber(SingularityClimber climber) {
		double climb = xbox.getRS_Y();
		if (Math.abs(climb) > 0.25) climber.setSpeed(climb);
		else climber.setSpeed(0.0);
	}

	@Override
	public void controlIntake(SingularityIntake intake) {
		
		if (xbox.getYButton() && !prevY) on = on ? false : true;
		if (!on) intake.setSpeed(0.0);
		else if (xbox.getXButton()) intake.setSpeed(-1.0);
		else intake.setSpeed(1.0);

	}

}

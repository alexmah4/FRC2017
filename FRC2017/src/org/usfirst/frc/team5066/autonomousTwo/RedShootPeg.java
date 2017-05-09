package org.usfirst.frc.team5066.autonomousTwo;

import org.usfirst.frc.team5066.library.SingularityDrive;
import org.usfirst.frc.team5066.library.SpeedMode;
import org.usfirst.frc.team5066.robot.LowGoalShooter;
import org.usfirst.frc.team5066.robot.SingularityIntake;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;

public class RedShootPeg extends AutonMode {
	
	public RedShootPeg(double gyroRotationConstant, AHRS gyro) {
		super(gyroRotationConstant, gyro);
	}

	@Override
	public void run(SingularityDrive drive, LowGoalShooter shooter, SingularityIntake intake) {
		
		//shoot
		shooter.setSpeed(true, true);
		Timer.delay(0.5);
		intake.setSpeed(1.0);
		
		Timer t = new Timer();
		t.reset();
		t.start();
		while (t.get() < 3.0) {
			
		}
		
		shooter.setSpeed(false, false);
		intake.setSpeed(0.0);
		
		//drive forward slightly
		double origAngle = gyro.getAngle();
		
		t.reset();
		t.start();
		
		while (t.get() < 4.0) {
			
			drive.arcadeSixWheel(0.25, 0.05 * (origAngle - gyro.getAngle()), false, SpeedMode.FAST);
		}
		
		drive.arcadeSixWheel(0.0, 0.0, true, SpeedMode.FAST);
		Timer.delay(0.4);
		/*
		//turn right slightly
		while(8.0 - (origAngle - gyro.getAngle()) > 4.0) {
			drive.arcadeSixWheel(0.0, 0.3, false, SpeedMode.FAST);
		}
		
		drive.arcadeSixWheel(0.0, 0.0, true, SpeedMode.FAST);
		Timer.delay(0.4);
		
		
		drive.rotateTo(10.0, 5.0);
		//go forward
		origAngle = gyro.getAngle();
		
		t.reset();
		t.start();
		
		while (t.get() < 1.8) {
			
			drive.arcadeSixWheel(0.35, 0.05 * (origAngle - gyro.getAngle()), false, SpeedMode.FAST);
		}
		
		drive.arcadeSixWheel(0.0, 0.0, false, SpeedMode.FAST);
		
		Timer.delay(0.4);
		/*
		//turn left slightly
		while(-4.0 + (origAngle - gyro.getAngle()) > -15.0) {
			drive.arcadeSixWheel(0.0, -0.3, false, SpeedMode.FAST);
		}
		
		drive.arcadeSixWheel(0.0, 0.0, true, SpeedMode.FAST);
		Timer.delay(0.4);
		
		
		drive.rotateTo(-25.0, 5.0);
		
		//drive forward
		origAngle = gyro.getAngle();
		
		t.reset();
		t.start();
		
		while (t.get() < 1.8) {
			
			drive.arcadeSixWheel(0.35, 0.05 * (origAngle - gyro.getAngle()), false, SpeedMode.FAST);
		}
		
		drive.arcadeSixWheel(0.0, 0.0, false, SpeedMode.FAST);
		*/
		
		
		
	}

}

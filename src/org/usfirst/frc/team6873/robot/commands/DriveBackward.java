package org.usfirst.frc.team6873.robot.commands;

import org.usfirst.frc.team6873.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveBackward extends Command {
	Timer timer = new Timer();
	double time = 0;
	
    public DriveBackward(double _time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);\
    	requires(Robot.driveSubsystem);
    	time = _time;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SmartDashboard.putString("Command", "Starting Drive Backward Command");
		SmartDashboard.putNumber("Time Limit", time);

    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SmartDashboard.putString("Command", "Running Drive Backward Command");
		SmartDashboard.putNumber("Timer", timer.get());
    	Robot.driveSubsystem.backward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (timer.get() > time);
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();
		SmartDashboard.putString("Command", "Stopping Drive Backward Command");

    	Robot.driveSubsystem.stop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {   
		SmartDashboard.putString("Command", "Interrupting Drive Backward Command");
		timer.stop();
		Robot.driveSubsystem.stop();
    }
}

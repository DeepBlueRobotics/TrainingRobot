package org.team199.trainingrobot;

import org.team199.trainingrobot.commands.AutonomousDrive;
import org.team199.trainingrobot.commands.AutonomousSpin;
import org.team199.trainingrobot.commands.RunMotorsWithJoystick;
import org.team199.trainingrobot.subsystems.Motors;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    private final Motors motors = new Motors();
    private final Joystick leftJoystick = new Joystick(Constants.OI.Controller.kJoystickLeft);
    private final Joystick rightJoystick = new Joystick(Constants.OI.Controller.kJoystickRight);

    public RobotContainer() {
        configureButtonBindingsController();
        // set default commands here
    }
    private void configureButtonBindingsController() {
        
        motors.setDefaultCommand(new RunMotorsWithJoystick(motors, leftJoystick, rightJoystick)); 
        new JoystickButton(leftJoystick, Constants.OI.Controller.leftTrigger).whenPressed(new InstantCommand(motors::changeMode));
    }

    public SequentialCommandGroup getAutonomousCommand() {
        return new SequentialCommandGroup(new AutonomousDrive(motors), new AutonomousSpin(motors));
    }
}
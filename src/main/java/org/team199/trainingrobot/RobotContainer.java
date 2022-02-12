package org.team199.trainingrobot;

import org.team199.trainingrobot.subsystems.Motors;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    private final Motors motors = new Motors();
    private final Joystick controller = new Joystick(Constants.OI.Controller.kPort);

    public RobotContainer() {
        configureButtonBindingsController();
        motors.setDefaultCommand(new RunCommand(motors::run, motors));
        // set default commands here
    }
    private void configureButtonBindingsController() {
    }

    public Command getAutonomousCommand() {
        return new InstantCommand();
    }
}
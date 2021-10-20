package org.team199.trainingrobot;

import org.team199.trainingrobot.commands.RunMotor;
import org.team199.trainingrobot.commands.RunMotorsWithJoystick;
import org.team199.trainingrobot.subsystems.Motors;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    private final Motors motors = new Motors();
    final Joystick joystick = new Joystick(0);
    private final Joystick controller = new Joystick(Constants.OI.Controller.kPort);
    
    
    public RobotContainer() {
        configureButtonBindingsController();
        // set default commands here
        motors.setDefaultCommand(new RunMotorsWithJoystick(joystick, motors));
    }
    private void configureButtonBindingsController() {
        new JoystickButton(controller, Constants.OI.Controller.kRunMotorsButton).whenPressed(new RunMotor(motors), true);
    }

    public Command getAutonomousCommand() {
        return new InstantCommand();
    }
}
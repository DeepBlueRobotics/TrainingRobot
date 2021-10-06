// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team199.trainingrobot.commands;

import org.team199.trainingrobot.Mode;
import org.team199.trainingrobot.subsystems.Motors;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunMotorsWithJoystick extends CommandBase {
  /** Creates a new RunMotorsWithJoystick. */
  private Motors motors;
  private Joystick leftJoystick;
  private Joystick rightJoystick;
  
  public RunMotorsWithJoystick(Motors motors, Joystick leftJoystick, Joystick rightJoystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.motors = motors);
    this.leftJoystick = leftJoystick;
    this.rightJoystick = rightJoystick;
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // true is tank, false is arcade
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // true is tank, false is arcade
    if (motors.getMode() == Mode.tank)
      motors.tankRun(-leftJoystick.getY(), rightJoystick.getY());
    else
      motors.arcadeRun(-leftJoystick.getX(), leftJoystick.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // true is tank, false is arcade
    if (motors.getMode() == Mode.tank)
      motors.tankRun(0, 0);
    else
      motors.arcadeRun(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

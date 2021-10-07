// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team199.trainingrobot.commands;

import org.team199.trainingrobot.subsystems.Motors;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutonomousSpin extends CommandBase {
  /** Creates a new AutonomousDrive. */
  private Motors motors;
  public AutonomousSpin(Motors motors) {
    addRequirements(this.motors = motors);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motors.autonomousSpin(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motors.autonomousSpin(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
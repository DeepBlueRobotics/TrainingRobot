/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.subsystems;

import org.team199.trainingrobot.Constants;

import frc.robot.lib.MotorControllerFactory;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class Motors extends SubsystemBase {
  // private final WPI_TalonSRX talon = MotorControllerFactory.createTalon(Constants.Drive.kTalon);
  private final CANSparkMax spark = MotorControllerFactory.createSparkMax(3);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Motors() {
    SmartDashboard.putNumber("Limit", 10);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Speed", spark.getEncoder().getVelocity());
      spark.setSmartCurrentLimit((int) SmartDashboard.getNumber("Limit", 10));
  }

  public void run() {
    spark.set(1);
  }
}

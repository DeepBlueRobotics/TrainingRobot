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
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class Motors extends SubsystemBase {
  private final WPI_TalonSRX talon = MotorControllerFactory.createTalon(Constants.Drive.kTalon);
  private final WPI_VictorSPX victor = MotorControllerFactory.createVictor(Constants.Drive.kVictor);
  private final CANSparkMax spark = MotorControllerFactory.createSparkMax(Constants.Drive.kSpark);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Motors() {
  }

  public void run(double speed) {
    talon.set(speed);
  }

  public void stop()
  {
    talon.set(0);
  }
}

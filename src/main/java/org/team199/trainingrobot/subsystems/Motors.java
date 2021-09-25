/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.team199.trainingrobot.subsystems;

import org.team199.trainingrobot.Constants;
import org.team199.trainingrobot.Mode;

import frc.robot.lib.MotorControllerFactory;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class Motors extends SubsystemBase {
  
  private Mode mode;
  private final CANSparkMax left1 = MotorControllerFactory.createSparkMax(Constants.Drive.kSparkMaxLeft1);
  private final CANSparkMax left2 = MotorControllerFactory.createSparkMax(Constants.Drive.kSparkMaxLeft2);
  private final SpeedControllerGroup left = new SpeedControllerGroup(left1, left2);

  private final CANSparkMax right1 = MotorControllerFactory.createSparkMax(Constants.Drive.kSparkMaxRight1);
  private final CANSparkMax right2 = MotorControllerFactory.createSparkMax(Constants.Drive.kSparkMaxRight2);
  private final SpeedControllerGroup right = new SpeedControllerGroup(right1, right2);
  private final DifferentialDrive drive = new DifferentialDrive(left, right);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Motors() {
    //sparkMax.follow(leader, invert)
    mode = Mode.tank;
  }

  public void tankRun(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void arcadeRun(double speed, double turn) {
    drive.arcadeDrive(speed, turn);
  }
  
  public Mode getMode() {
    return mode;
  }

  public void changeMode() {
    if (mode == Mode.tank)
      mode = Mode.arcade; // Changes it to Arcade Mode
    else
      mode = Mode.arcade; // Changes it to Tank Mode
  }
}

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

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class Motors extends SubsystemBase {
  
  private Mode mode;
  private final double slow = 0.5;

  private final CANSparkMax leftMaster = MotorControllerFactory.createSparkMax(Constants.Drive.kSparkMaxLeft1);
  private final CANSparkMax leftSlave = MotorControllerFactory.createSparkMax(Constants.Drive.kSparkMaxLeft2);
  private final SpeedControllerGroup left = new SpeedControllerGroup(leftMaster, leftSlave);

  private final CANSparkMax rightMaster = MotorControllerFactory.createSparkMax(Constants.Drive.kSparkMaxRight1);
  private final CANSparkMax rightSlave = MotorControllerFactory.createSparkMax(Constants.Drive.kSparkMaxRight2);
  private final SpeedControllerGroup right = new SpeedControllerGroup(rightMaster, rightSlave);
  private final DifferentialDrive drive = new DifferentialDrive(left, right);

  private final CANEncoder leftEnc = leftMaster.getEncoder();
  private final CANEncoder rightEnc = rightMaster.getEncoder();
  private final double conversion = (Math.PI * 5.0) / 6.8;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Motors() {
    //sparkMax.follow(leader, invert)
    mode = Mode.tank;
    leftEnc.setPosition(0);
    rightEnc.setPosition(0);
    leftEnc.setPositionConversionFactor(conversion);
    rightEnc.setPositionConversionFactor(conversion);
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
    rightMaster.setInverted(true);
  }

  public void tankRun(double leftSpeed, double rightSpeed) {
    drive.tankDrive(slow*leftSpeed, slow*rightSpeed);
  }

  public void arcadeRun(double speed, double turn) {
    drive.arcadeDrive(slow*speed, turn);
  }
  
  public Mode getMode() {
    return mode;
  }

  public void changeMode() {
    if (mode == Mode.tank)
      mode = Mode.arcade; // Changes it to Arcade Mode
    else
      mode = Mode.tank; // Changes it to Tank Mode
  }

  public CANEncoder getEnc()
  {
    return leftEnc;
  }

  public void autonomousSpin(double rotation)
  {
    drive.tankDrive(rotation, -rotation);
  }
}

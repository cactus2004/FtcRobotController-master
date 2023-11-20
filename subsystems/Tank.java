package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Tank {

    private DcMotorEx driveRight;
    private DcMotorEx driveLeft;

    public Tank(HardwareMap hardwareMap){

        //TODO Change the green text to match the names in the config
        driveRight = hardwareMap.get(DcMotorEx.class, "rightDrive");
        driveLeft = hardwareMap.get(DcMotorEx.class, "leftDrive");

        //TODO Change these directions to match your robot
        driveRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveLeft.setDirection(DcMotorSimple.Direction.FORWARD);

        driveRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        driveLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        driveLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        driveRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void tankDrive(double leftAxis, double rightAxis){

        driveLeft.setPower(leftAxis);
        driveRight.setPower(rightAxis);

    }

    public void arcadeDrive(double driveAxis, double turnAxis){

        driveLeft.setPower(driveAxis + turnAxis);
        driveRight.setPower(driveAxis - turnAxis);

    }

    public double tankPosition(){

        return driveLeft.getCurrentPosition();

    }

}

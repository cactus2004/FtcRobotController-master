package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Mecanum {

    private DcMotorEx driveBackLeft,driveFrontLeft, driveFrontRight, driveBackRight;
    private DcMotorEx[] motors = {driveFrontLeft, driveFrontRight,
            driveBackLeft, driveBackLeft};

    public Mecanum(HardwareMap hardwareMap){

        //TODO Change the green text to match the names in the config
        driveBackLeft = hardwareMap.get(DcMotorEx.class, "backLeftDrive");
        driveFrontLeft = hardwareMap.get(DcMotorEx.class, "frontLeftDrive");
        driveBackRight = hardwareMap.get(DcMotorEx.class, "backRightDrive");
        driveFrontRight = hardwareMap.get(DcMotorEx.class, "frontRightDrive");

        for (DcMotorEx motor: motors){
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

        //TODO Change these directions to match your robot
        driveBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveFrontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        driveBackLeft.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    public void tankDrive(double leftAxis,double rightAxis){

        driveBackRight.setPower(rightAxis);
        driveFrontRight.setPower(rightAxis);
        driveFrontLeft.setPower(leftAxis);
        driveBackLeft.setPower(leftAxis);

    }

    public void holonomicDrive(double forwardAxis, double strafeAxis, double rotationAxis){

        driveBackRight.setPower(forwardAxis - strafeAxis + rotationAxis);
        driveFrontRight.setPower(forwardAxis + strafeAxis + rotationAxis);
        driveFrontLeft.setPower(forwardAxis - strafeAxis - rotationAxis);
        driveBackLeft.setPower(forwardAxis + strafeAxis - rotationAxis);

    }

}

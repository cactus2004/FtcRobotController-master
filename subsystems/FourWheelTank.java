package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FourWheelTank {

    private DcMotorEx driveBackRight;
    private DcMotorEx driveBackLeft;
    private DcMotorEx driveFrontRight;
    private DcMotorEx driveFrontLeft;

    DcMotorEx[] motors = {driveFrontLeft, driveBackLeft, driveBackRight, driveFrontRight};


    public FourWheelTank(HardwareMap hardwareMap){

        //TODO Change the deviceNames to fit your robot configuration
        driveBackLeft = hardwareMap.get(DcMotorEx.class, "backLeftDrive");
        driveFrontLeft = hardwareMap.get(DcMotorEx.class, "frontLeftDrive");
        driveBackRight = hardwareMap.get(DcMotorEx.class, "backRightDrive");
        driveFrontRight = hardwareMap.get(DcMotorEx.class, "frontRightDrive");

        for(DcMotorEx motor: motors){
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

        //TODO Make sure these directions are correct
        driveBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveFrontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        driveBackLeft.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    public void tankDrive(double leftAxis, double rightAxis){

        driveBackRight.setPower(rightAxis);
        driveFrontRight.setPower(rightAxis);
        driveFrontLeft.setPower(leftAxis);
        driveBackLeft.setPower(leftAxis);

    }

    public void arcadeDrive(double driveAxis, double turnAxis){

        driveBackLeft.setPower(driveAxis + turnAxis);
        driveFrontLeft.setPower(driveAxis + turnAxis);
        driveBackRight.setPower(driveAxis - turnAxis);
        driveFrontRight.setPower(driveAxis - turnAxis);


    }

}

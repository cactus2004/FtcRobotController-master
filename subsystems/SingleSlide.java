package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SingleSlide {

    private DcMotorEx lift;

    //TODO Change this number (again ranging from 0.0 - 1.0) to be the power that
    //TODO will keep the slides up, but not extend on its own
    private double feedForward = 0.0;

    public SingleSlide(HardwareMap hardwareMap){

        //TODO Change the green text to match the name in your config
        lift = hardwareMap.get(DcMotorEx.class, "lift");

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //TODO Change this direction to match your robot
        lift.setDirection(DcMotorSimple.Direction.FORWARD);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void extend(double speed){
        lift.setPower(Math.abs(speed));
    }

    public void retract(double speed){
        lift.setPower(-Math.abs(speed) * 0.80);
    }

    public void rest(){
        lift.setPower(feedForward);
    }

}

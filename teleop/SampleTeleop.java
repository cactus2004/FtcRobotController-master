package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp

public class SampleTeleop extends LinearOpMode {

    double DRIFTTOLERANCE = 0.05;
    double SENSITIVITY = 1.0;

    public void runOpMode(){

        Robot robot = new Robot(hardwareMap);

        if (isStopRequested()) return;
        waitForStart();

        while(opModeIsActive()) {

            double yLeft =
                Math.abs(gamepad1.left_stick_y) > DRIFTTOLERANCE?
                        -gamepad1.left_stick_y * SENSITIVITY: 0;

            double xLeft =
                Math.abs(gamepad1.left_stick_x) > DRIFTTOLERANCE?
                         gamepad1.left_stick_x * SENSITIVITY: 0;

            double xRight =
                Math.abs(gamepad1.right_stick_x) > DRIFTTOLERANCE?
                         gamepad1.right_stick_x * SENSITIVITY: 0;

            //TODO this will move the robot using the left stick, and turn it with the right stick
            robot.mecanum.holonomicDrive(yLeft, xLeft, xRight);


            if(gamepad1.left_bumper){
                robot.claw.openClaw();
            }

            if (gamepad1.right_bumper){
                robot.claw.closeClaw();
            }

            if(gamepad1.dpad_up){
                robot.slide.extend(0.5);
            }else if (gamepad1.dpad_down){
                robot.slide.retract(0.5);
            }else{
                robot.slide.rest();
            }

        }
    }
}

package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {

    private Servo claw;

    //TODO Change these positions to match open and closed on your claw
    //TODO numbers range for 0.0 to  1.0
    double openPosition = 0.0;
    double closedPosition = 1.0;

    public Claw(HardwareMap hardwareMap, boolean open){

        //TODO change the green text to match the name of your servo in the config
        claw = hardwareMap.get(Servo.class, "claw");

        double initialPosition = open?
                openPosition: closedPosition;

        claw.setPosition(initialPosition);

    }

    public void openClaw(){
        claw.setPosition(openPosition);
    }

    public void closeClaw(){
        claw.setPosition(closedPosition);
    }

}

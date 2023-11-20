package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.Mecanum;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.SingleSlide;
import org.firstinspires.ftc.teamcode.subsystems.Tank;
import org.firstinspires.ftc.teamcode.subsystems.FourWheelTank;


public class Robot {
    public Mecanum mecanum;
    public Claw claw;
    public SingleSlide slide;
    public Tank tank;
    public FourWheelTank fourWheelTank;

    public Robot(HardwareMap hardwareMap){

        //TODO delete mechanisms not on your robot, and remove the // on
        //TODO mechanisms you do use.
        mecanum = new Mecanum(hardwareMap);
        claw = new Claw(hardwareMap,false);
        slide = new SingleSlide(hardwareMap);
        //tank = new Tank(hardwareMap);
        //fourWheelTank = new FourWheelTank(hardwareMap);
        
    }

}

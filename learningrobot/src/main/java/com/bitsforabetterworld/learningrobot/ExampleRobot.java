package com.bitsforabetterworld.learningrobot;

public class ExampleRobot extends RobotCommand {
    private final RobotSensorInterface sensors;
    private final RobotDrivingInterface drive;

    public ExampleRobot(RobotSensorInterface sensors, RobotDrivingInterface drive) {
        this.sensors = sensors;
        this.drive = drive;
    }
    @Override
    protected void initialize() {
        System.out.println("Initializing...");
    }

    @Override
    protected void execute() {
        double forwardSpeed = 0.01;
        drive.setSpeed(forwardSpeed, 0.0, 0.0);
    }

    @Override
    protected void end() {
        System.out.println("Done.");
    }

    @Override
    protected  boolean isFinished() {
        return sensors.isTargetReached();
    }

}
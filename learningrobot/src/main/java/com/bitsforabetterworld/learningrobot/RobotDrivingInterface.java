package com.bitsforabetterworld.learningrobot;

public interface RobotDrivingInterface {
    public void setSpeed(
        double forwardSpeed /* m/s, with negative being backwards*/, 
        double rightSpeed /* m/s, with negative being leftwards*/,
        double rotationSpeed /* degrees/second, with negative being counterclockwise*/);
}
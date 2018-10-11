package com.bitsforabetterworld.learningrobot;

public interface RobotSensorInterface {
    // Returns true if you are "close enough" to the target, and false otherwise
    public boolean isTargetReached();

    // What is the direction to the target, in degrees?
    public double getDirectionToTarget();

    // What is the distance to the target, in meters?
    public double getDistanceToTarget();
}
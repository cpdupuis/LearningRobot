package com.bitsforabetterworld.learningrobot;

public class Robot implements RobotSensorInterface, RobotDrivingInterface {
    private final double targetX;
    private final double targetY;
    private double robotX;
    private double robotY;
    private double robotRotation;
    private double forwardSpeed = 0.0;
    private double rightSpeed = 0.0;
    private double rotationSpeed = 0.0;
    private static final double EPSILON = 0.01; // 1 cm
    private static final double SAFE_SPEED = 0.01; // 1 cm/sec
    private boolean isCrashed = false;

    public Robot(double robotX, double robotY, double robotRotation, double targetX, double targetY) {
        this.robotX = robotX;
        this.robotY = robotY;
        this.targetX = targetX;
        this.targetY = targetY;
        this.robotRotation = robotRotation;
    }

    @Override
    public void setSpeed(
        double forwardSpeed /* m/s, with negative being backwards*/, 
        double rightSpeed /* m/s, with negative being leftwards*/,
        double rotationSpeed /* degrees/second, with negative being counterclockwise*/)
    {
        this.forwardSpeed = forwardSpeed;
        this.rightSpeed = rightSpeed;
        this.rotationSpeed = rotationSpeed;
    }

    @Override
    // Returns true if you are "close enough" to the target, and false otherwise
    public boolean isTargetReached() {
        // Pythagorean theorem!
        double distance = getDistanceToTarget();
        if (distance < EPSILON) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isCrashed() {
        if (isCrashed) {
            // If we've crashed, we stay crashed.
            return true;
        }
        if (isTargetReached()) {
            // Did we hit the target when driving too fast?
            double speed = Math.pow(Math.pow(forwardSpeed, 2.0) + Math.pow(rightSpeed, 2.0), 0.5);
            if (speed > SAFE_SPEED) {
                this.isCrashed = true;
                throw new RuntimeException("You crashed! Speed at the target was " + speed + ", which is more than the safe speed of " + SAFE_SPEED);
            }
        }
        return false;
    }

    public double getRobotX() {
        return robotX;
    }

    public double getRobotY() {
        return robotY;
    }

    @Override
    // What is the direction to the target in the robot's perspective, in degrees?
    public double getDirectionToTarget() {
        double xToTarget = targetX - robotX;
        double yToTarget = targetY - robotY;
        
        double angleRadians =  Math.atan2(yToTarget, xToTarget);
        double angleDegrees = Math.toDegrees(angleRadians);

        return (angleDegrees + robotRotation) % 360.0;
    } 
    
    @Override
    // What is the distance to the target, in meters?
    public double getDistanceToTarget() {
        double x2 = Math.pow(targetX - robotX, 2.0);
        double y2 = Math.pow(targetY - robotY, 2.0);
        return Math.pow(x2 + y2, 0.5);
    }

    public void updateTime(long milliseconds) {
        double interval = milliseconds / 1000.0;
        double rotationRad = Math.toRadians(robotRotation);
        double ySpeed = Math.cos(rotationRad) * forwardSpeed - Math.sin(rotationRad) * rightSpeed;
        double xSpeed = Math.cos(rotationRad) * rightSpeed + Math.sin(rotationRad) * forwardSpeed;

        robotX += xSpeed * interval;
        robotY += ySpeed * interval;
        robotRotation = (robotRotation + (rotationSpeed * interval)) % 360.0;
    }
}
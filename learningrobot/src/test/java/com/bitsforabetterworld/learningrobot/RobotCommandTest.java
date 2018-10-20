package com.bitsforabetterworld.learningrobot;

import static org.junit.Assert.*;

import org.junit.Test;


public class RobotCommandTest {
    @Test
    public void driveForward() {
        Robot robot = new Robot(0.0, 0.0, 0.0, 0.0, 10.0);
        RobotCommand command = new ExampleRobot(robot, robot);
        int totalMillis = 0;
        while (! command.isFinished()&& totalMillis < 100000000) {
            command.runOneIteration();
            robot.updateTime(20);
            totalMillis += 20;
        }
        assertEquals("Y position", 10.0, robot.getRobotY(), 0.01);
        assertEquals("X position", 0.0, robot.getRobotX(), 0.01);
        assertEquals("Angle", 0.0, robot.getRobotAngle(), 0.1);
        assertTrue(robot.isTargetReached());
        assertFalse(robot.isCrashed());
    }

    @Test
    public void driveForwardFaster() {
        Robot robot = new Robot(0.0, 0.0, 0.0, 0.0, 10.0);
        RobotCommand command = new ExampleRobot(robot, robot);
        int totalMillis = 0;
        while (! command.isFinished() && totalMillis < 10000) {
            command.runOneIteration();
            robot.updateTime(20);
            totalMillis += 20;
        }
        assertEquals("Y position", 10.0, robot.getRobotY(), 0.01);
        assertEquals("X position", 0.0, robot.getRobotX(), 0.01);
        assertEquals("Angle", 0.0, robot.getRobotAngle(), 0.1);
        assertTrue("Not reached", robot.isTargetReached());
        assertFalse("Crashed", robot.isCrashed());
    }

    @Test
    public void turnAndDrive() {
        Robot robot = new Robot(0.0, 0.0, 0.0, 3.0, 4.0);
        RobotCommand command = new ExampleRobot(robot, robot);
        int totalMillis = 0;
        while (! command.isFinished() && totalMillis < 1000000) {
            command.runOneIteration();
            robot.updateTime(20);
            totalMillis += 20;
        }
        assertEquals("X position", 3.0, robot.getRobotX(), 0.01);
        assertEquals("Y position", 4.0, robot.getRobotY(), 0.01);
       // assertEquals("Angle", 0.0, robot.getRobotAngle(), 0.1);
        assertTrue("Not reached", robot.isTargetReached());
        assertFalse("Crashed", robot.isCrashed());
    }
}
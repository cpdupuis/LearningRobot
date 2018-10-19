package com.bitsforabetterworld.learningrobot;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotCommandTest {
    @Test
    public void driveForward() {
        Robot robot = new Robot(0.0, 0.0, 0.0, 0.0, 10.0);
        RobotCommand command = new ExampleRobot(robot, robot);
        while (! command.isFinished()) {
            command.runOneIteration();
            robot.updateTime(20);
        }
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
        assertEquals("Not 10:"+robot.getRobotY(), 10.0, robot.getRobotY(), 0.01);
        assertTrue("Not reached", robot.isTargetReached());
        assertFalse("Crashed", robot.isCrashed());
    }
}
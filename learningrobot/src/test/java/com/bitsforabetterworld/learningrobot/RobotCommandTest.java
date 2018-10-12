package com.bitsforabetterworld.learningrobot;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotCommandTest {
    @Test
    public void testDriveForward() {
        Robot robot = new Robot(0.0, 0.0, 0.0, 0.0, 10.0);
        RobotCommand command = new ExampleRobot(robot, robot);
        while (! command.isFinished()) {
            command.runOneIteration();
            robot.updateTime(20);
        }
        assertTrue(robot.isTargetReached());
        assertFalse(robot.isCrashed());
    }
}
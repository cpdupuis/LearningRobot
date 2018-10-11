package com.bitsforabetterworld.learningrobot;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotCommandTest {
    @Test
    public void testDriveForward() throws InterruptedException {
        Robot robot = new Robot(0.0, 0.0, 0.0, 0.0, 10.0);
        RobotCommand command = new ExampleRobot(robot, robot);
        command.run();
        assertTrue(robot.isTargetReached());
        assertFalse(robot.isCrashed());
    }
}
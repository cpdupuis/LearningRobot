package com.bitsforabetterworld.learningrobot;

import static org.junit.Assert.*;

import org.junit.Test;

// Test cases for Robot.java
public class RobotTest {
    @Test
    public void driveForward() {
        // target is 10 meters directly in front of robot
        Robot robot = new Robot(0.0, 0.0, 0.0, 0.0, 10.0);
        robot.setSpeed(10.0, 0.0, 0.0);
        assertFalse(robot.isTargetReached());
        assertFalse(robot.isCrashed());
        robot.updateTime(1000);
        assertTrue(robot.isTargetReached());
        assertTrue(robot.isCrashed());
    }

    @Test
    public void driveRight() {
        // target is 10 meters to the right of robot
        Robot robot = new Robot(0.0, 0.0, 0.0, 10.0, 0.0);
        robot.setSpeed(0.0, 10.0, 0.0);
        assertFalse(robot.isTargetReached());
        assertFalse(robot.isCrashed());
        robot.updateTime(1000);
        assertEquals(0.0, robot.getRobotY(), 0.01);
        assertEquals(10.0, robot.getRobotX(), 0.01);
        assertEquals(0.0, robot.getDistanceToTarget(), 0.01);
        assertTrue(robot.isTargetReached());
        assertTrue(robot.isCrashed());
    }

    @Test
    public void driveLeft() {
        // target is 10 meters to the left of robot
        Robot robot = new Robot(0.0, 0.0, 0.0, -10.0, 0.0);
        robot.setSpeed(0.0, -10.0, 0.0);
        assertFalse(robot.isTargetReached());
        assertFalse(robot.isCrashed());
        robot.updateTime(1000);
        assertEquals(0.0, robot.getRobotY(), 0.01);
        assertEquals(-10.0, robot.getRobotX(), 0.01);
        assertEquals(0.0, robot.getDistanceToTarget(), 0.01);
        assertTrue(robot.isTargetReached());
        assertTrue(robot.isCrashed());

    }

    @Test
    public void driveBackwards() {
        // target is 10 meters behind robot
        Robot robot = new Robot(0.0, 0.0, 0.0, 0.0, -10.0);
        robot.setSpeed(-10.0, 0.0, 0.0);
        assertFalse(robot.isTargetReached());
        assertFalse(robot.isCrashed());
        robot.updateTime(1000);
        assertEquals(-10.0, robot.getRobotY(), 0.01);
        assertEquals(0.0, robot.getRobotX(), 0.01);
        assertEquals(0.0, robot.getDistanceToTarget(), 0.01);
        assertTrue(robot.isTargetReached());
        assertTrue(robot.isCrashed());
    }

    @Test
    public void turnRightAndDrive() {
        // target is 10 meters to the right of robot
        Robot robot = new Robot(0.0, 0.0, 0.0, 10.0, 0.0);
        robot.setSpeed(0.0, 0.0, 90.0);
        assertFalse(robot.isTargetReached());
        assertFalse(robot.isCrashed());
        robot.updateTime(1000);
        robot.setSpeed(10.0, 0.0, 0.0);
        robot.updateTime(1000);
        assertEquals(0.0, robot.getRobotY(), 0.01);
        assertEquals(10.0, robot.getRobotX(), 0.01);
        assertEquals(0.0, robot.getDistanceToTarget(), 0.01);
        assertTrue(robot.isTargetReached());
        assertTrue(robot.isCrashed());
    }

    @Test
    public void safeArrival() {
        // target is 10 meters directly in front of robot
        Robot robot = new Robot(0.0, 0.0, 0.0, 0.0, 10.0);
        robot.setSpeed(0.01, 0.0, 0.0);
        assertFalse(robot.isTargetReached());
        assertFalse(robot.isCrashed());
        robot.updateTime(1000000);
        assertEquals(10.0, robot.getRobotY(), 0.01);
        assertTrue(robot.isTargetReached());
        assertFalse(robot.isCrashed());

    }
}
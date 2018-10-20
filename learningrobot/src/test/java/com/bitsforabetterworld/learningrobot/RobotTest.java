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
        try {
            assertTrue(robot.isCrashed());
        }
        catch (RuntimeException ex) {
            // expected
        }
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
        try {
            assertTrue(robot.isCrashed());
        }
        catch (RuntimeException ex) {
            // expected.
        }
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
        try {
            assertTrue(robot.isCrashed());
        }
        catch (RuntimeException ex) {
            // expected
        }

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
        try {
            assertTrue(robot.isCrashed());
        }
        catch (RuntimeException ex) {
            // expected
        }
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
        try {
            assertTrue(robot.isCrashed());
        }
        catch (RuntimeException ex) {
            // expected
        }
    }

    @Test
    public void turnLeftAndDrive() {
        // target is 10 meters to the right of robot
        Robot robot = new Robot(0.0, 0.0, 0.0, -10.0, 0.0);
        robot.setSpeed(0.0, 0.0, -90.0);
        assertFalse(robot.isTargetReached());
        assertFalse(robot.isCrashed());
        robot.updateTime(1000);
        robot.setSpeed(10.0, 0.0, 0.0);
        robot.updateTime(1000);
        assertEquals(0.0, robot.getRobotY(), 0.01);
        assertEquals(-10.0, robot.getRobotX(), 0.01);
        assertEquals(0.0, robot.getDistanceToTarget(), 0.01);
        assertTrue(robot.isTargetReached());
        try {
            assertTrue(robot.isCrashed());
        }
        catch (RuntimeException ex) {
            // expected
        }
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

    @Test
    public void directionIs45() {
        Robot robot = new Robot(0.0, 0.0, 0.0, 7.07, 7.07);
        assertEquals(45.0, robot.getDirectionToTarget(), 0.01);
    }
    @Test
    public void directionIsNeg45() {
        Robot robot = new Robot(0.0, 0.0, 0.0, -7.07, 7.07);
        assertEquals(-45.0, robot.getDirectionToTarget(), 0.01);
    }

    @Test
    public void directionIs135() {
        Robot robot = new Robot(0.0, 0.0, 0.0, 7.07, -7.07);
        assertEquals(135.0, robot.getDirectionToTarget(), 0.01);
    }
    @Test
    public void directionIsNeg135() {
        Robot robot = new Robot(0.0, 0.0, 0.0, -7.07, -7.07);
        assertEquals(-135.0, robot.getDirectionToTarget(), 0.01);
    }
}

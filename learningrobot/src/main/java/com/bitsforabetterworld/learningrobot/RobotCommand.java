package com.bitsforabetterworld.learningrobot;


// This is a simplified version of Command: first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/command/Command.html
public abstract class RobotCommand {
    private boolean isInitialized = false;

    protected abstract void initialize();

    protected abstract void execute();

    protected abstract void end();

    protected abstract boolean isFinished();

    public final synchronized void run() throws InterruptedException {
        if (!isInitialized) {
            initialize();
            isInitialized = true;
        }
        while (!isFinished()) {
            execute();
            this.wait(20);
        }
        end();
    }
}
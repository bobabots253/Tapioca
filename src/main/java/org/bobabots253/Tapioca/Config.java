package org.bobabots253.Tapioca;

public class Config {
    /* Differential Drive Settings */
    public static class DriverConstants {
        /* Common drive mode settings */
        // How much of joystick is "dead" zone [0,1]
        public static double kJoystickDeadband = 0.07;
        // Overall speed setting (turn down for demos) [0,1]
        public static double kDriveSens = 1.0;
        // Maximum turn-in-place rate (in percent of max) to allow robot to turn to [0,1]
        public static double kTurnInPlaceSens = 0.5;
        // Maximum normal turning rate (in percent of max) to allow robot to turn to [0,1]
        public static double kTurnSens = 1;
    }
}

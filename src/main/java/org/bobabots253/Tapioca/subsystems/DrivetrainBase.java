package org.bobabots253.Tapioca.subsystems;

import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj2.command.Subsystem;

public abstract class DrivetrainBase implements Subsystem {
    /**
     * The kinematics object for this drivetrain.
     */
    public final DifferentialDriveKinematics KINEMATICS;
    
    /**
     * The feedforward object for this drivetrain.
     */
    public final SimpleMotorFeedforward FEEDFORWARD;
    
    public DrivetrainBase(DrivetrainConfig config) {
        this.KINEMATICS = new DifferentialDriveKinematics(config.kTrackWidth);
        this.FEEDFORWARD = new SimpleMotorFeedforward(config.kS, config.kV, config.kA);
    }
    
    /**
     * An object to be passed to your Tapioca drivetrain.
     * Setters for this class return the instance they were called on, useful for chaining methods.
     */
    public static final class DrivetrainConfig {
        double kTrackWidth;
        double kP = 0;
        double kI = 0;
        double kD = 0;
        double kS = 0;
        double kV = 0;
        double kA = 0;
        
        public DrivetrainConfig setKTrackWidth(double kTrackWidth) {
            this.kTrackWidth = kTrackWidth;
            return this;
        }
        
        public DrivetrainConfig setKP(double kP) {
            this.kP = kP;
            return this;
        }
        
        public DrivetrainConfig setKI(double kI) {
            this.kI = kI;
            return this;
        }
        
        public DrivetrainConfig setKD(double kD) {
            this.kD = kD;
            return this;
        }
        
        public DrivetrainConfig setKS(double kS) {
            this.kS = kS;
            return this;
        }
        
        public DrivetrainConfig setKV(double kV) {
            this.kV = kV;
            return this;
        }
        
        public DrivetrainConfig setKA(double kA) {
            this.kA = kA;
            return this;
        }
    }
}

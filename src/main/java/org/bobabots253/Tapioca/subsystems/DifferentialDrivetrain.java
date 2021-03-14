package org.bobabots253.Tapioca.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpiutil.math.MathUtil;

/**
 * An abstract class for differential drivetrains.
 *
 * @see edu.wpi.first.wpilibj.drive.DifferentialDrive
 */
public abstract class DifferentialDrivetrain extends DrivetrainBase {
    /**
     * The {@link PIDController} for the left motors of the drivetrain.
     */
    public final PIDController LEFT_PID_CONTROLLER;
    
    /**
     * The {@link PIDController} for the right motors of the drivetrain.
     */
    public final PIDController RIGHT_PID_CONTROLLER;
    
    /**
     * The {@link SpeedControllerGroup} for the left motors of the drivetrain.
     */
    public final SpeedControllerGroup LEFT_SPEED_CONTROLLER;
    
    /**
     * The {@link SpeedControllerGroup} for the right motors of the drivetrain.
     */
    public final SpeedControllerGroup RIGHT_SPEED_CONTROLLER;
    
    /**
     * Constructs a new DifferentialDrivetrain with the provided {@link SpeedControllerGroup}s.
     * It is recommended to make your subclass a singleton with a private constructor.
     *
     * @param config The configuration for this drivetrain.
     * @param leftController The left SpeedControllerGroup for this DifferentialDrivetrain.
     * @param rightController The right SpeedControllerGroup for this DifferentialDrivetrain.
     */
    public DifferentialDrivetrain(DrivetrainConfig config, SpeedControllerGroup leftController, SpeedControllerGroup rightController) {
        super(config);
        this.LEFT_PID_CONTROLLER = new PIDController(config.kP, config.kI, config.kD);
        this.RIGHT_PID_CONTROLLER = new PIDController(config.kP, config.kI, config.kD);
        this.LEFT_SPEED_CONTROLLER = leftController;
        this.RIGHT_SPEED_CONTROLLER = rightController;
    }
    
    /**
     * Sets drivetrain speeds in open loop (% of max voltage).
     * This method also clamps input to [-1, 1].
     *
     * @param left   Percent output of motors on left side of drivetrain
     * @param right  Percent output of motors on right side of drivetrain
     */
    public void setOpenLoop(double left, double right) {
        LEFT_SPEED_CONTROLLER.set(MathUtil.clamp(left, -1, 1));
        RIGHT_SPEED_CONTROLLER.set(MathUtil.clamp(right, -1, 1));
    }
}

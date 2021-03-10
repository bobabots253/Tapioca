package org.bobabots253.Tapioca;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import org.bobabots253.Tapioca.utils.Calc;

public class XboxController extends edu.wpi.first.wpilibj.XboxController {
    /**
     * Construct an instance of a joystick. The joystick index is the USB port on the drivers station.
     *
     * @param port The port on the Driver Station that the joystick is plugged into.
     */
    public XboxController(int port) {
        super(port);
    }
    
    /**
     * Get the virtual {@link JoystickButton} that corresponds to the physical button on the Xbox controller.
     *
     * @param button The {@link Button} to get.
     * @return A new {@link JoystickButton} object.
     */
    public JoystickButton getButton(Button button) {
        return new JoystickButton(this, button.ordinal());
    }
    
    /**
     * Get the virtual {@link POVButton} that corresponds to the physical button on the Xbox controller.
     *
     * @param direction The directional {@link POVButton} to get.
     * @return A new {@link POVButton} object.
     */
    public POVButton getButton(CompassPOV direction) {
        return new POVButton(this, direction);
    }
    
    public enum DeadbandAxis {
        JOYSTICKS,
        TRIGGERS,
    }
    
    private double m_joystickDeadband = 0.0;
    private double m_triggerDeadband = 0.0;
    
    /**
     * Sets the deadband value for this object.
     *
     * Value are Deadbanded to [-1, -deadband], [deadband, 1],
     * and rescaled to be linear from (deadband, 0) to (1,1)
     *
     * @param deadband The deadband value
     * @param axis The axis to deadband
     */
    public void setDeadband(double deadband, DeadbandAxis axis) {
        switch (axis) {
            case JOYSTICKS:
                this.m_joystickDeadband = deadband;
                break;
            case TRIGGERS:
                this.m_triggerDeadband = deadband;
                break;
        }
    }
    
    /**
     * Get the trigger axis value of the controller.
     *
     * @param hand Side of controller whose value should be returned.
     * @param deadbanded Whether or not to apply deadband to the returned value.
     * @return The trigger axis value of the controller.
     */
    public double getTriggerAxis(Hand hand, boolean deadbanded) {
        double val = super.getTriggerAxis(hand);
        if (deadbanded) val = Calc.applyDeadband(val, m_triggerDeadband);
        return val;
    }
    
    /**
     * Get the trigger axis value of the controller, with deadband applied.
     *
     * @param hand Side of controller whose value should be returned.
     * @return The trigger axis value of the controller.
     */
    @Override
    public double getTriggerAxis(Hand hand) {
        return this.getTriggerAxis(hand, true);
    }
    
    /**
     * Get the X axis value of the controller.
     *
     * @param hand Side of controller whose value should be returned.
     * @param deadbanded Whether or not to apply deadband to the returned value.
     * @return The X axis value of the controller.
     */
    public double getX(Hand hand, boolean deadbanded) {
        double val = super.getX(hand);
        if (deadbanded) val = Calc.applyDeadband(val, m_joystickDeadband);
        return val;
    }
    
    /**
     * Get the X axis value of the controller, with deadband applied.
     *
     * @param hand Side of controller whose value should be returned.
     * @return The X axis value of the controller.
     */
    @Override
    public double getX(Hand hand) {
        return this.getX(hand, true);
    }
    
    /**
     * Get the Y axis value of the controller.
     *
     * @param hand Side of controller whose value should be returned.
     * @param deadbanded Whether or not to apply deadband to the returned value.
     * @return The Y axis value of the controller.
     */
    public double getY(Hand hand, boolean deadbanded) {
        double val = super.getY(hand);
        if (deadbanded) val = Calc.applyDeadband(val, m_joystickDeadband);
        return val;
    }
    
    /**
     * Get the Y axis value of the controller, with deadband applied.
     *
     * @param hand Side of controller whose value should be returned.
     * @return The Y axis value of the controller.
     */
    @Override
    public double getY(Hand hand) {
        return this.getY(hand, true);
    }
}

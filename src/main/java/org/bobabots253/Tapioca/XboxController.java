package org.bobabots253.Tapioca;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import org.bobabots253.Tapioca.utils.Deadband;

public class XboxController extends edu.wpi.first.wpilibj.XboxController {
    /**
     * Construct an instance of a joystick. The joystick index is the USB port on the drivers station.
     *
     * @param port The port on the Driver Station that the joystick is plugged into.
     */
    public XboxController(int port) {
        super(port);
        this.m_joystickDeadband = Deadband.dummy();
        this.m_triggerDeadband = Deadband.dummy();
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
    
    private Deadband m_joystickDeadband;
    private Deadband m_triggerDeadband;
    
    /**
     * Sets the deadband for this object.
     *
     * @param deadband The deadband to set
     * @param axis The axis to deadband
     */
    public void setDeadband(Deadband deadband, DeadbandAxis axis) {
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
     * Get the deadband for this object.
     *
     * @param axis The deadbanded axis.
     * @return The deadband object for the deadbanded axis.
     */
    public Deadband getDeadband(DeadbandAxis axis) {
        switch (axis) {
            case JOYSTICKS:
                return m_joystickDeadband;
            case TRIGGERS:
                return m_triggerDeadband;
            default:
                throw new AssertionError("Passed invalid DeadbandAxis to getDeadband");
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
        if (deadbanded) val = m_triggerDeadband.calculate(val);
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
        if (deadbanded) val = m_joystickDeadband.calculate(val);
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
        if (deadbanded) val = m_joystickDeadband.calculate(val);
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

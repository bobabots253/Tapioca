package org.bobabots253.Tapioca;

import edu.wpi.first.wpilibj.GenericHID;

public class POVButton extends edu.wpi.first.wpilibj2.command.button.POVButton {
    /**
     *
     * @param joystick The GenericHID object that has the POV
     * @param angle    The desired angle (e.g. 90, 270)
     */
    public POVButton(GenericHID joystick, int angle) {
        super(joystick, angle);
    }
    
    /**
     *
     * @param joystick The GenericHID object that has the POV
     * @param pov      The desired angle in enum format
     */
    public POVButton(GenericHID joystick, CompassPOV pov) {
        super(joystick, pov.getAngle());
    }
}
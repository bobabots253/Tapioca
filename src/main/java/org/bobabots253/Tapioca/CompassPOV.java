package org.bobabots253.Tapioca;

/**
 * An enum that represents POV in cardinal directions.
 *
 * @author Sebastian Law
 *
 * @see org.bobabots253.Tapioca.POVButton
 */
public enum CompassPOV {
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST,
    NONE;
    
    /**
     * Get the angle in degrees of a POV.
     *
     * The POV angles start at 0 with {@link #NORTH},
     * and increase clockwise (eg {@link #EAST} is 90, {@link #NORTHWEST} is 315).
     *
     * @return The angle of the POV in degrees, or -1 if {@link #NONE}.
     */
    public int getAngle() {
        if (this == NONE) return -1;
        return this.ordinal() * 45;
    }
}

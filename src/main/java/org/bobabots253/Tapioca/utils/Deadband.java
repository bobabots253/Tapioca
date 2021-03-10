package org.bobabots253.Tapioca.utils;

/**
 * An abstract class representing an input deadband, with input values in the range [-1, 1]
 *
 * @author Sebastian Law
 *
 * @see org.bobabots253.Tapioca.XboxController
 */
public abstract class Deadband {
    protected double m_deadbandValue = 0.0;
    protected double m_maximum = 1;
    
    /**
     * Calculate the deadbanded output based on the input and set deadband.
     *
     * @param input The input value to deadband and scale from [-1, 1]
     * @return The deadbanded and scaled input.
     */
    public abstract double calculate(double input);
    
    /**
     * Sets the deadband value to be used in {@link #calculate}.
     *
     * @param value The double value to be used for the deadband.
     */
    public final void setDeadband(double value) {
        this.m_deadbandValue = value;
    }
    
    /**
     * @return The set deadband value.
     */
    public final double getDeadband() {
        return this.m_deadbandValue;
    }
    
    /**
     * Sets the maximum value to be used for scaling in {@link #calculate}.
     *
     * @param value The double value to be used for the maximum.
     */
    public final void setMaximum(double value) {
        this.m_maximum = value;
    }
    
    /**
     * @return The set maximum value.
     */
    public final double getMaximum() {
        return this.m_maximum;
    }
    
    /**
     * A dummy deadband that can be used as a default value.
     */
    private static class DummyDeadband extends Deadband {
        @Override
        public double calculate(double input) {
            return input;
        }
    }
    
    /**
     * @return A dummy Deadband instance that just returns the input from {@link #calculate}.
     */
    public static Deadband dummy() {
        return new DummyDeadband();
    }
}

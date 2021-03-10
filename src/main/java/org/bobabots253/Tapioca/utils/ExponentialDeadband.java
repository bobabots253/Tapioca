package org.bobabots253.Tapioca.utils;

/**
 * This class can be used to increase your driver's precision at speeds that matter.
 * <p>
 * Providing a weight greater than {@code 1} increases granularity at lower input values while decreasing granularity at higher input values.
 * <br>
 * Providing a weight less than {@code 1} decreases granularity at lower input values while increasing granularity at higher input values.
 *
 * @author Sebastian Law
 *
 * @see <a href="https://www.desmos.com/calculator/y01izjqnaz">Desmos Graph Visualization of Exponential Deadband Scaling</a>
 */
public class ExponentialDeadband extends LinearDeadband {
    protected double m_weight;
    
    /**
     * @param weight The weight value to be used for scaling in {@link #calculate}.
     */
    public ExponentialDeadband(double weight) {
        setWeight(weight);
    }
    
    @Override
    public double calculate(double input) {
        return Math.signum(input) * Math.pow(super.calculate(Math.abs(input)), m_weight);
    }
    
    /**
     * Sets the weight value to be used for scaling in {@link #calculate}.
     *
     * @param value The double value to be used for the weight.
     * @throws IllegalArgumentException If {@code value} is less than or equal to zero.
     */
    public final void setWeight(double value) {
        if (value <= 0) throw new IllegalArgumentException("ExponentialDeadband weight must be greater than zero.");
        this.m_weight = value;
    }
    
    /**
     * @return The set weight value.
     */
    public final double getWeight() {
        return this.m_weight;
    }
}

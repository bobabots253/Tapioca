package org.bobabots253.Tapioca.utils;

/**
 * Deadbands an input to {@code [-maximum, -deadband], [deadband, maximum]},
 * rescaling outputs to be linear from {@code [-1, 0], [0, 1]}
 *
 * @author Sebastian Law
 *
 * @see <a href="https://www.desmos.com/calculator/fww1zwmfab">Desmos Graph Visualization of Linear Deadband Scaling</a>
 */
public class LinearDeadband extends Deadband {
    @Override
    public double calculate(double input) {
        double abs = Math.abs(input);
        
        if (abs <= m_deadbandValue) {
            return 0;
        } else if (abs >= m_maximum) {
            return input;
        } else {
            return (input - Math.signum(input) * m_deadbandValue) / (m_maximum - m_deadbandValue);
        }
    }
}

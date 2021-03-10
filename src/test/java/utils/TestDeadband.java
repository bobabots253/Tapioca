package utils;

import org.bobabots253.Tapioca.utils.Deadband;
import org.bobabots253.Tapioca.utils.LinearDeadband;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TestDeadband {
    @Test
    public void testDummyDeadband() {
        Deadband dummy = Deadband.dummy();
        Random random = new Random();
        
        for (int i = 0; i < 100; i++) {
            double val = random.nextDouble();
            assertEquals(dummy.calculate(val), val, 0);
        }
    }
    
    @Test
    public void testLinearDeadband() {
        final Deadband deadband = new LinearDeadband();
        deadband.setDeadband(0.25);
        
        // deadband to zero
        assertEquals(0, deadband.calculate(0.1), 0);
        assertEquals(0, deadband.calculate(0.2), 0);
        
        // scale linearly
        assertEquals(0.3, deadband.calculate(0.5), 0.1);
        assertEquals(0.06, deadband.calculate(0.3), 0.01);
        
        // stay at 1
        assertEquals(1, deadband.calculate(1), 0);
    }
}

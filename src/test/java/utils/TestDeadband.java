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
    
    private void testDeadbandMinimum(Deadband deadband) {
        // constants to reset after
        double db = deadband.getDeadband(), max = deadband.getMaximum();
        
        deadband.setDeadband(0.25);
        deadband.setMaximum(1);  // don't let maximum affect these tests
    
        assertEquals(0, deadband.calculate(0.1), 0);
        assertEquals(0, deadband.calculate(0.2), 0);
    
        deadband.setDeadband(db);
        deadband.setMaximum(max);
    }
    
    private void testDeadbandMaximum(Deadband deadband) {
        // constants to reset after
        double db = deadband.getDeadband(), max = deadband.getMaximum();
        
        deadband.setDeadband(0);  // don't let minimum affect these tests
        deadband.setMaximum(0.9);
    
        assertEquals(1, deadband.calculate(0.9), 0);
        assertEquals(-1, deadband.calculate(-0.9), 0);
        
        deadband.setDeadband(db);
        deadband.setMaximum(max);
    }
    
    @Test
    public void testLinearDeadband() {
        final Deadband deadband = new LinearDeadband();
        
        testDeadbandMaximum(deadband);
        testDeadbandMinimum(deadband);
        
        deadband.setDeadband(0.25);
        // scale linearly
        assertEquals(0.3, deadband.calculate(0.5), 0.1);
        assertEquals(0.06, deadband.calculate(0.3), 0.01);
    }
}

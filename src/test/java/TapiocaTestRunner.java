import org.bobabots253.Tapioca.utils.Calc;
import org.junit.Test;

import static org.junit.Assert.*;

public class TapiocaTestRunner {
    public static class UtilsTest {
        public static class CalcTest {
            @Test
            public void testDeadband() {
                final double deadband = 0.25;
                
                // deadband to zero
                assertEquals(0, Calc.applyDeadband(0.1, deadband), 0);
                assertEquals(0, Calc.applyDeadband(0.2, deadband), 0);
                
                // scale linearly
                assertEquals(0.3, Calc.applyDeadband(0.5, deadband), 0.1);
                assertEquals(0.06, Calc.applyDeadband(0.3, deadband), 0.01);
                
                // stay at 1
                assertEquals(1, Calc.applyDeadband(1, deadband), 0);
            }
        }
    }
    
    public static class ExampleTestClass {
        @Test
        public void exampleTestMethod() {
            assertTrue(true);
        }
    }
}

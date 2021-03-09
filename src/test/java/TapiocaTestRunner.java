import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        /* Add inner classes here */
        TapiocaTestRunner.ExampleTestClass.class,
})
public class TapiocaTestRunner {
    public static class ExampleTestClass {
        @Test
        public void exampleTestMethod() {
            assertTrue(true);
        }
    }
}

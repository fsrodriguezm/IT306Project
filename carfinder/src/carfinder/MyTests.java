package carfinder;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyTests {

        @Test
        public void sampleTest() {
            User tester = new User(); // MyClass is tested

                // assert statements
                assertEquals("sample@email.com must return true", true, tester.setEmail("sample@email.com"));
//                assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
//                assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
        }
}
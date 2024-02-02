package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Helper;

public class Hooks {

    @Before
    public static void setUp() {
        Helper.setUpDriver();
    }

    @After
    public static void tearDown() {
        Helper.tearDown();
    }
}
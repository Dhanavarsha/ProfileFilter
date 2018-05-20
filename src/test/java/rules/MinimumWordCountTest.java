package rules;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class MinimumWordCountTest {
    @Test
    public void testInterpret() throws Exception {
        MinimumWordCount rule = new MinimumWordCount("Selenium", 2);
        Assert.assertTrue(rule.interpret("Selenium automates browsers. That's it!" +
                "Selenium's wiki strongly encourages using page objects." +
                "selenium also favors assertion-free page objects."));
        Assert.assertFalse(rule.interpret("Selenium automates browsers. That's it!"));
    }

}
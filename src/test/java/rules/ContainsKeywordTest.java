package rules;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContainsKeywordTest {
    @Test
    public void testInterpret() throws Exception {
        ContainsKeyword rule = new ContainsKeyword("Java");
        Assert.assertTrue(rule.interpret("I love java"));
        Assert.assertFalse(rule.interpret("I love Swift"));
    }
}
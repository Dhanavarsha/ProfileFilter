package rules;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AnyRuleTest {
    @Test
    public void testInterpret() throws Exception {
        ArrayList<Rule> listOfRules = new ArrayList<Rule>();
        listOfRules.add(RuleUtils.createMockRuleReturning(false));
        listOfRules.add(RuleUtils.createMockRuleReturning(false));
        Rule rule = new AnyRule(listOfRules);

        Assert.assertFalse(rule.interpret(""));

        listOfRules.add(RuleUtils.createMockRuleReturning(true));

        Assert.assertTrue(rule.interpret(""));
    }
}
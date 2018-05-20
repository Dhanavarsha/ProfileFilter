package rules;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AllRulesTest {
    @Test
    public void testInterpret() throws Exception {
        ArrayList<Rule> listOfRules = new ArrayList<Rule>();
        listOfRules.add(RuleUtils.createMockRuleReturning(true));
        listOfRules.add(RuleUtils.createMockRuleReturning(true));
        Rule rule = new AllRules(listOfRules);

        Assert.assertTrue(rule.interpret(""));

        listOfRules.add(RuleUtils.createMockRuleReturning(false));

        Assert.assertFalse(rule.interpret(""));
    }
}
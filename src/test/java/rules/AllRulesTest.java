package rules;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AllRulesTest {
    @Test
    public void testInterpret() throws Exception {
        ArrayList<Rule> listOfRules = new ArrayList<Rule>();
        listOfRules.add(createMockRuleReturning(true));
        listOfRules.add(createMockRuleReturning(true));
        Rule rule = new AllRules(listOfRules);
        Assert.assertTrue(rule.interpret(""));
        listOfRules.add(createMockRuleReturning(false));
        Assert.assertFalse(rule.interpret(""));
    }

    private Rule createMockRuleReturning(boolean returnValue) {
        Rule mockedRule = mock(Rule.class);
        when(mockedRule.interpret(anyString())).thenReturn(returnValue);
        return mockedRule;
    }
}
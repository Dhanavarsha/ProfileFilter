package rules;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class AnyRuleTest {
    @Test
    public void testInterpret() throws Exception {
        ArrayList<Rule> listOfRules = new ArrayList<Rule>();
        listOfRules.add(createMockRuleReturning(false));
        listOfRules.add(createMockRuleReturning(false));

        Rule rule = new AnyRule(listOfRules);
        Assert.assertFalse(rule.interpret(""));

        listOfRules.add(createMockRuleReturning(true));
        Assert.assertTrue(rule.interpret(""));
    }

    private Rule createMockRuleReturning(boolean returnValue) {
        Rule mockedRule = mock(Rule.class);
        when(mockedRule.interpret(anyString())).thenReturn(returnValue);
        return mockedRule;
    }

}
package rules;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RuleUtils {
    public static Rule createMockRuleReturning(boolean returnValue) {
        Rule mockedRule = mock(Rule.class);
        when(mockedRule.interpret(anyString())).thenReturn(returnValue);
        return mockedRule;
    }
}

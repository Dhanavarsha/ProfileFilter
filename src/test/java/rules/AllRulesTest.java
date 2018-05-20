package rules;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class AllRulesTest {
    @Test
    public void testInterpret() throws Exception {
        ArrayList<Rule> listOfRules = new ArrayList<Rule>();
        listOfRules.add(new ContainsKeyword("selenium"));
        listOfRules.add(new ContainsKeyword("appium"));
        listOfRules.add(new ContainsKeyword("java"));
        Rule rule = new AllRules(listOfRules);
        Assert.assertTrue(rule.interpret("Appium supports all languages that have Selenium " +
                "client libraries like- Java, Objective-C, JavaScript with node.js, PHP, Ruby, Python, C#, etc."));
        Assert.assertFalse(rule.interpret("Basically, Appium derives its roots from Selenium and it" +
                " uses JSONWireProtocol internally to interact with iOS and Android apps using Selenium's WebDriver"));
    }

}
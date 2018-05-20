import org.testng.Assert;
import org.testng.annotations.Test;
import rules.AllRules;
import rules.ContainsKeyword;
import rules.Rule;

import java.io.File;
import java.util.ArrayList;

public class ProfileFilterTests {
    @Test
    public void testDocumentReader() {
        File file = new File("src/main/resources/Test.doc");
        Assert.assertEquals(DocumentReader.getDocumentText(file).trim(), "Hello World!");
    }

    @Test
    public void testContainsKeywordRule() {
        File file = new File("src/main/resources/DD_Resume.doc");
        ContainsKeyword rule = new ContainsKeyword("Java");
        Assert.assertTrue(rule.interpret(DocumentReader.getDocumentText(file)));
    }

    @Test
    public void testForMultipleKeywords() {
        File file = new File("src/main/resources/DD_Resume.doc");
        ArrayList<Rule> listOfRules = new ArrayList<Rule>();
        listOfRules.add(new ContainsKeyword("Selenium"));
        listOfRules.add(new ContainsKeyword("Appium"));
        listOfRules.add(new ContainsKeyword("Java"));
        Rule rule = new AllRules(listOfRules);
        Assert.assertTrue(rule.interpret(DocumentReader.getDocumentText(file)));
    }
}

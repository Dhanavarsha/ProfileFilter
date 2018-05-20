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
        DocumentReader reader = new DocumentReader();
        Assert.assertEquals(reader.getDocumentText(file).trim(), "Hello World!");
    }

    @Test
    public void testContainsKeywordRule() {
        File file = new File("src/main/resources/DD_Resume.doc");
        ProfileFilter filter = new ProfileFilter(file);
        ContainsKeyword rule = new ContainsKeyword("Selenium");
        Assert.assertTrue(filter.isSelected(rule));
    }

    @Test
    public void testForMultipleKeywords() {
        File file = new File("src/main/resources/DD_Resume.doc");
        DocumentReader reader = new DocumentReader();
        ArrayList<Rule> listOfRules = new ArrayList<Rule>();
        listOfRules.add(new ContainsKeyword("Selenium"));
        listOfRules.add(new ContainsKeyword("Appium"));
        listOfRules.add(new ContainsKeyword("Java"));
        Rule rule = new AllRules(listOfRules);
        Assert.assertTrue(rule.interpret(reader.getDocumentText(file)));
    }
}

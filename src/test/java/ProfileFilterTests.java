import org.testng.Assert;
import org.testng.annotations.Test;
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
        ProfileFilter filter = new ProfileFilter(file);
        ArrayList<Rule> rules = new ArrayList<Rule>();
        rules.add(new ContainsKeyword("Selenium"));
        rules.add(new ContainsKeyword("Appium"));
        rules.add(new ContainsKeyword("Java"));
        Assert.assertTrue(filter.isSelected(rules));
    }
}

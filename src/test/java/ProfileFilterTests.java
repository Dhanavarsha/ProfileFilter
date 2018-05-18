import org.testng.Assert;
import org.testng.annotations.Test;
import rules.ContainsKeyword;

import java.io.File;

public class ProfileFilterTests {
    @Test
    public void testDocumentReader() {
        File file = new File("src/main/resources/Test.doc");
        DocumentReader reader = new DocumentReader();
        Assert.assertEquals(reader.getDocumentText(file).trim(), "Hello World!");
    }

    @Test
    public void testContainsRule() {
        File file = new File("src/main/resources/DD_Resume.doc");
        ProfileFilter filter = new ProfileFilter(file);
        ContainsKeyword rule = new ContainsKeyword("Selenium");
        Assert.assertTrue(filter.isSelected(rule));
    }
}

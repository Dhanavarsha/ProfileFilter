import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ProfileFilterTests {
    @Test
    public void testDocumentReader() {
        File file = new File("src/main/resources/Test.doc");
        DocumentReader reader = new DocumentReader();
        Assert.assertEquals(reader.getDocumentText(file).trim(), "Hello World!");
    }

    @Test
    public void testProfileFilter() {
        File file = new File("src/main/resources/DD_Resume.doc");
        ProfileFilter filter = new ProfileFilter();
        String[] keywords = new String[]{"Selenium", "Appium", "Java", "Travis"};
        Assert.assertTrue(filter.isProfileSelected(file, keywords));
    }
}

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
}

package documentReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DocReaderTest {
    @Test
    public void testGetDocumentText() throws Exception {
        File docFile = new File("src/main/resources/Test.doc");
        Assert.assertEquals(new DocReader().getDocumentText(docFile).trim(), "Hello World!");
    }
}
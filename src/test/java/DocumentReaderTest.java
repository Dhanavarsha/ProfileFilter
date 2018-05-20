import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class DocumentReaderTest {
    @Test
    public void testGetDocumentText() throws Exception {
        File file = new File("src/main/resources/Test.doc");
        Assert.assertEquals(DocumentReader.getDocumentText(file).trim(), "Hello World!");
    }
}
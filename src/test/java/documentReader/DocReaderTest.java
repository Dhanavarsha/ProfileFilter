package documentReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DocReaderTest {
    @Test
    public void testGetDocumentText() throws Exception {
        File docFile = new File("src/main/resources/Test.doc");
        Assert.assertEquals(DocumentTypeClassifier.getDocumentText(docFile).trim(), "Hello World!");
        Assert.assertFalse(DocumentTypeClassifier.getDocumentText(docFile).trim().equalsIgnoreCase("negativeTest"));
    }
}
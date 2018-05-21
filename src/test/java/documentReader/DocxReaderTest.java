package documentReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DocxReaderTest {
    @Test
    public void testGetDocumentText() throws Exception {
        File docxFile = new File("src/main/resources/test.docx");
        Assert.assertEquals(DocumentTypeClassifier.getDocumentText(docxFile).trim(), "test");
        Assert.assertFalse(DocumentTypeClassifier.getDocumentText(docxFile).trim().equalsIgnoreCase("negativeTest"));
    }
}
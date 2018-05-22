package documentReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DocxReaderTest {
    @Test
    public void testGetDocumentText() throws Exception {
        File docxFile = new File("src/main/resources/test.docx");
        Assert.assertEquals(new DocxReader().getDocumentText(docxFile).trim(), "test");
    }
}
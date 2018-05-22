package documentReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PDFReaderTest {
    @Test
    public void testGetDocumentText() throws Exception {
        File pdfFile = new File("src/main/resources/sample.pdf");
        Assert.assertEquals(new PDFReader().getDocumentText(pdfFile), "SAMPLE PDF FILE");
    }
}
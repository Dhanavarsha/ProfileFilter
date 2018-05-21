package documentReader;

import documentReader.DocumentReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DocumentReaderTest {
    @Test
    public void testGetDocumentText() throws Exception {
        File docFile = new File("src/main/resources/Test.doc");
        Assert.assertEquals(DocumentReader.getDocumentText(docFile).trim(), "Hello World!");

        File docxFile = new File("src/main/resources/test.docx");
        Assert.assertEquals(DocumentReader.getDocumentText(docxFile).trim(), "test");

        File pdfFile = new File("src/main/resources/sample.pdf");
        Assert.assertEquals(DocumentReader.getDocumentText(pdfFile), "SAMPLE PDF FILE");
    }
}
package documentReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainDocumentReaderTest {
    @Test
    public void testGetDocumentText() throws Exception {
        File pdfFile = new File("sample_random.pdf");
        File xlsFile = new File("sample_random.xls");
        ArrayList<DocumentReader> readerList = new ArrayList<>();
        readerList.add(createMockedReader("pdf", "PDF Sring"));
        readerList.add(createMockedReader("doc", "Doc String"));
        readerList.add(createMockedReader("docx", "Docx String"));
        Assert.assertEquals(MainDocumentReader.getDocumentText(pdfFile, readerList), "PDF Sring");
        Assert.assertEquals(MainDocumentReader.getDocumentText(xlsFile, readerList), "");
    }

    private DocumentReader createMockedReader(String mockExtension, String mockText) {
        DocumentReader mockReader = mock(DocumentReader.class);
        when(mockReader.getSupportedExtension()).thenReturn(mockExtension);
        when(mockReader.getDocumentText(any())).thenReturn(mockText);
        return mockReader;
    }
}
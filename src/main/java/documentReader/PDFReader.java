package documentReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;

public class PDFReader implements DocumentReader {
    private File file = null;
    private String text = "";

    public PDFReader(File file) {
        this.file = file;
    }

    public String getDocumentText() {
        try {
            PDDocument document = PDDocument.load(file);
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper textStripper = new PDFTextStripper();
                text = textStripper.getText(document).trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.File;
import java.io.FileInputStream;

public class DocumentReader {
    public static String getDocumentText(File file) {
        FileInputStream fis;
        String text = null;
        try {
            fis = new FileInputStream(file);
            HWPFDocument document = new HWPFDocument(fis);
            WordExtractor wordExtractor = new WordExtractor(document);
            text = wordExtractor.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}

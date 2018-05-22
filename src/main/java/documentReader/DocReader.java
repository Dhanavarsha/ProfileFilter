package documentReader;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.File;
import java.io.FileInputStream;

public class DocReader implements DocumentReader {

    public String getDocumentText(File file) {
        String text = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument document = new HWPFDocument(fis);
            WordExtractor wordExtractor = new WordExtractor(document);
            text = wordExtractor.getText();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    @Override
    public String getSupportedExtension() {
        return "doc";
    }
}

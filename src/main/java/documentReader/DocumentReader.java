package documentReader;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class DocumentReader {
    public static String getDocumentText(File file) {
        String s = getFileExtension(file);
        FileInputStream fis;
        String text = "";

        if (s.equals("doc")) {
            try {
                fis = new FileInputStream(file);
                HWPFDocument document = new HWPFDocument(fis);
                WordExtractor wordExtractor = new WordExtractor(document);
                text = wordExtractor.getText();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return text;
        } else if (s.equals("docx")) {
            try {
                fis = new FileInputStream(file);
                XWPFDocument document = new XWPFDocument(fis);
                List<XWPFParagraph> paragraphs = document.getParagraphs();
                for (XWPFParagraph paragraph : paragraphs) {
                    text = text + paragraph.getText();
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return text;
        }
        return "";
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}

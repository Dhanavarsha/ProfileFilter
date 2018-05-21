package documentReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DocumentTypeClassifier {



    public static String getDocumentText(File file) {
        String fileExtension = getFileExtension(file);
        return Optional.ofNullable(documentReaders(file).get(fileExtension))
                .map(documentReader -> documentReader.getDocumentText())
                .orElse("");
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    private static Map<String, DocumentReader> documentReaders(File file) {
        HashMap<String, DocumentReader> map = new HashMap<String, DocumentReader>();
        map.put("doc", new DocReader(file));
        map.put("docx", new DocxReader(file));
        map.put("pdf", new PDFReader(file));
        return map;
    }
}

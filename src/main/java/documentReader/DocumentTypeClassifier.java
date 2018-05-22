package documentReader;

import java.io.File;
import java.util.List;

public class DocumentTypeClassifier {

    public static String getDocumentText(File file, List<DocumentReader> readers) {
        String fileExtension = getFileExtension(file);

        for (DocumentReader reader : readers) {
            if (reader.getSupportedExtension().equals(fileExtension)) {
                return reader.getDocumentText(file);
            }
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

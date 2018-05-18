import java.io.File;

public class ProfileFilter {
    private DocumentReader reader;

    public ProfileFilter() {
        this.reader = new DocumentReader();
    }

    public boolean isProfileSelected(File file, String keyword) {
        String documentText = reader.getDocumentText(file);
        return getIndexOfSearchString(keyword, documentText) != -1;
    }

    private int getIndexOfSearchString(String keyword, String documentText) {
        return documentText.toLowerCase().indexOf(keyword.toLowerCase());
    }
}

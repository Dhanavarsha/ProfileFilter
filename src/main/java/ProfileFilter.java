import java.io.File;

public class ProfileFilter {
    private DocumentReader reader;

    public ProfileFilter() {
        this.reader = new DocumentReader();
    }

    public boolean isProfileSelected(File file, String[] keywords) {
        String documentText = reader.getDocumentText(file);
        for (String keyword : keywords) {
            if (getIndexOfSearchString(keyword, documentText) == -1) {
                return false;
            }
        }
        return true;
    }

    private int getIndexOfSearchString(String keyword, String documentText) {
        return documentText.toLowerCase().indexOf(keyword.toLowerCase());
    }
}

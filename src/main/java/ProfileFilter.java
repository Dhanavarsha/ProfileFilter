import rules.ContainsKeyword;

import java.io.File;

public class ProfileFilter {
    private File file;
    private DocumentReader reader;

    public ProfileFilter(File file) {
        this.file = file;
        this.reader = new DocumentReader();
    }

    public boolean isSelected(ContainsKeyword rule) {
        return rule.interpret(reader.getDocumentText(file));
    }
}

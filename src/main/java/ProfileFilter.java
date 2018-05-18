import rules.ContainsKeyword;
import rules.Rule;

import java.io.File;
import java.util.ArrayList;

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

    public boolean isSelected(ArrayList<Rule> rules) {
        for (Rule rule : rules) {
            if (!rule.interpret(reader.getDocumentText(file))) {
                return false;
            }
        }
        return true;
    }
}

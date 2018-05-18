package rules;

public class ContainsKeyword implements Rule {
    private String word;

    public ContainsKeyword(String word) {
        this.word = word;
    }

    public boolean interpret(String documentText) {
        if (documentText.toLowerCase().contains(word.toLowerCase()))
            return true;
        else
            return false;
    }
}

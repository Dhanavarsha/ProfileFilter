package rules;

import java.util.Scanner;

public class MinimumWordCount implements Rule {
    private int minimumCount;
    private String word;

    public MinimumWordCount(String word, int count) {
        this.word = word;
        this.minimumCount = count;
    }

    public boolean interpret(String documentText) {
        return getCountOfWordOccurrence(documentText) >= minimumCount;
    }

    private int getCountOfWordOccurrence(String documentText) {
        int count = 0;
        Scanner scanner = new Scanner(documentText);
        String lowerCasedWord = word.toLowerCase();
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.toLowerCase().contains(lowerCasedWord))
                count++;
        }
        return count;
    }
}

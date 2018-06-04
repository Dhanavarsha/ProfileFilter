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
        String lowerCaseWord = word.toLowerCase();
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine().toLowerCase();
            String words[] = nextLine.split("\\s");
            for (String word : words) {
                if (word.contains(lowerCaseWord))
                    count++;
            }
        }
        return count;
    }
}

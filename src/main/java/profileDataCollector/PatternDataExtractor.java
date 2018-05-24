package profileDataCollector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class PatternDataExtractor implements DataExtractor {

    abstract String getPattern();

    @Override
    public String getData(String documentText) {
        Pattern pattern = Pattern.compile(getPattern());
        Matcher matcher = pattern.matcher(documentText);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}

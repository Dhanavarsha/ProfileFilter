package profileDataCollector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class PatternDataCollector implements DataCollector {

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

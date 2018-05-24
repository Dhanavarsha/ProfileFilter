package profileDataCollector;

class Contact extends PatternDataCollector {

    @Override
    String getPattern() {
        return "(\\+91?(\\s?|\\-?)\\d{10})|(\\d{10})|(\\(?\\+91?\\)?(\\-|\\s)?\\d{3}\\s?\\d{3}\\s?\\d{4})";
    }

    @Override
    public String getDataType() {
        return "Contact";
    }
}

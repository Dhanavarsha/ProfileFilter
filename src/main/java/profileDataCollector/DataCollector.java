package profileDataCollector;

public interface DataCollector {
    String getDataType();
    String getData(String documentText);
}

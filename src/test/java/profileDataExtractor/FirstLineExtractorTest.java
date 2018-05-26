package profileDataExtractor;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FirstLineExtractorTest {
    @Test
    public void testGetData() throws Exception {
        String sample = "Name : Test Name           " +
                "Email : testName@gmail.com\n" +
                "Resume details ..............\n";
        Assert.assertEquals("Name : Test Name           Email : testName@gmail.com",
                new FirstLineExtractor().getData(sample));
    }
}
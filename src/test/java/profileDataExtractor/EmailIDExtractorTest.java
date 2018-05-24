package profileDataExtractor;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailIDExtractorTest {
    @Test
    public void testGetPattern() throws Exception {
        String emailIdsList = "Email : dhan.varsha03@gmail.com  EmaildID : kritikaModi@yahoo.in, siddharth.parekh@outlook.com";
        Pattern pattern = Pattern.compile(new EmailIDExtractor().getPattern());
        Matcher matcher = pattern.matcher(emailIdsList);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        Assert.assertEquals(count, 3);
    }

    @Test
    public void testGetDataType() throws Exception {
        Assert.assertTrue(new EmailIDExtractor().getDataType().equalsIgnoreCase("Email ID"));
    }
}
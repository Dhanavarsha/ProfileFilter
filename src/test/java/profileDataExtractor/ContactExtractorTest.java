package profileDataExtractor;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.*;

public class ContactExtractorTest {
    @Test
    public void testGetPattern() throws Exception {
        String contactsInDifferentFormat = "ContactNo:+91-8009094960, Phone No: (+91) 9164947767, 9892016546,+91-8009094960, +91 959 094 2973";
        Pattern pattern = Pattern.compile(new ContactExtractor().getPattern());
        Matcher matcher = pattern.matcher(contactsInDifferentFormat);
        int count = 0;
        while (matcher.find())
            count++;
        Assert.assertEquals(Integer.toString(count), "5");
    }

    @Test
    public void testGetDataType() throws Exception {
        Assert.assertTrue(new ContactExtractor().getDataType().equalsIgnoreCase("Contact"));
    }

}
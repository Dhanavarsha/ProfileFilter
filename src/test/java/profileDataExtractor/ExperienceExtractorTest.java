package profileDataExtractor;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExperienceExtractorTest {
    @Test
    public void testGetData() {
        String sampleText1 = "Total 4.5 years of experience in software industry.";
        Assert.assertEquals(new ExperienceExtractor().getData(sampleText1), "4.5");

        String sampleText2 = "Work Experience : 5+ years";
        Assert.assertEquals(new ExperienceExtractor().getData(sampleText2), "5");

        String sampleText3 = "Experience on Selenium & Appium";
        Assert.assertEquals(new ExperienceExtractor().getData(sampleText3), "Unable to retrieve experience");
    }
}
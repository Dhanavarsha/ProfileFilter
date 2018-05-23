package profileDataCollector;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetExperienceTest {
    @Test
    public void testGetExperience() {
        String sampleText1 = "Total 4.5 years of experience in software industry.";
        Assert.assertEquals(new GetExperience().getExperience(sampleText1), "4.5");

        String sampleText2 = "Work Experience : 5+ years";
        Assert.assertEquals(new GetExperience().getExperience(sampleText2), "5");

        String sampleText3 = "Experience on Selenium & Appium";
        Assert.assertEquals(new GetExperience().getExperience(sampleText3), "Experience years not mentioned");
    }
}
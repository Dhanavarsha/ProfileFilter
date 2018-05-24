import documentReader.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import rules.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileFilterTest {
    @Test
    public void testRulesIntegration() throws UnsupportedFileException {
        File file = new File("src/main/resources/resumes/DD_Resume.doc");
        String documentText = MainDocumentReader.getDocumentText(file, getDocumentReadersList());

        Rule rule1 = getRuleForMandatorySkills();
        Rule rule2 = getRuleForCITools();

        ArrayList<Rule> selectionRules = new ArrayList<Rule>();
        selectionRules.add(rule1);
        selectionRules.add(rule2);

        Rule selectionRule1 = new AllRules(selectionRules);

        Assert.assertTrue(selectionRule1.interpret(documentText));

        Rule rule3 = getRuleForCertification();

        selectionRules.add(rule3);

        Rule selectionRule2 = new AllRules(selectionRules);

        Assert.assertFalse(selectionRule2.interpret(documentText));
    }

    private List<DocumentReader> getDocumentReadersList() {
        List<DocumentReader> readerList = new ArrayList<>();
        readerList.add(new DocxReader());
        readerList.add(new PDFReader());
        readerList.add(new DocReader());
        return readerList;
    }

    private Rule getRuleForCertification() {
        ArrayList<Rule> certifications = new ArrayList<Rule>();
        certifications.add(new ContainsKeyword("Certified Disciplined Agilist"));
        certifications.add(new ContainsKeyword("PMI Agile Certified Practitioner"));
        return new AnyRule(certifications);
    }

    private Rule getRuleForCITools() {
        ArrayList<Rule> skillsWithOptions = new ArrayList<Rule>();
        skillsWithOptions.add(new MinimumWordCount("Travis", 1));
        skillsWithOptions.add(new ContainsKeyword("Jenkins"));
        return new AnyRule(skillsWithOptions);
    }

    private Rule getRuleForMandatorySkills() {
        ArrayList<Rule> mandatorySkills = new ArrayList<Rule>();
        mandatorySkills.add(new MinimumWordCount("Selenium", 3));
        mandatorySkills.add(new MinimumWordCount("Appium", 3));
        mandatorySkills.add(new MinimumWordCount("Java", 2));
        mandatorySkills.add(new ContainsKeyword("REST"));
        mandatorySkills.add(new ContainsKeyword("API Testing"));
        return new AllRules(mandatorySkills);
    }
}

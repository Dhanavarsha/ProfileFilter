package app;

import documentReader.*;
import documentReader.exceptions.UnsupportedFileException;
import fileWriter.OutputFileGenerator;
import org.apache.commons.io.FileUtils;
import profileDataExtractor.*;
import rules.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public void parseProfiles(File resumeFolder, Rule selectionRule) {

        for (File file : resumeFolder.listFiles()) {

            try {
                String documentText = MainDocumentReader.getDocumentText(file, getDocumentReadersList());
                if (selectionRule.interpret(documentText)) {
                    ProfileComposer composer = new ProfileComposer(getDataExtractors());
                    OutputFileGenerator.writeToFile(file.getName(),
                            composer.getDataType() + "\n\n" + composer.getData(documentText));
                    FileUtils.copyFile(file, getDestinationForSelectedProfile(file));
                } else {
                    FileUtils.copyFile(file, getDestinationForRejectedProfile(file));
                }
            } catch (Exception e) {

            } catch (UnsupportedFileException e) {
                e.printStackTrace();
            }
        }
    }

    private File getDestinationForRejectedProfile(File file) {
        return new File(System.getProperty("user.dir") + "/target/rejectedProfiles/" + file.getName());
    }

    private File getDestinationForSelectedProfile(File file) {
        return new File(System.getProperty("user.dir") + "/target/selectedProfiles/" + file.getName());
    }

    private ArrayList<DataExtractor> getDataExtractors() {
        ArrayList<DataExtractor> dataExtractors = new ArrayList<>();
        dataExtractors.add(new FirstLineExtractor());
        dataExtractors.add(new ExperienceExtractor());
        dataExtractors.add(new ContactExtractor());
        dataExtractors.add(new EmailIDExtractor());
        return dataExtractors;
    }

    private List<DocumentReader> getDocumentReadersList() {
        List<DocumentReader> readerList = new ArrayList<>();
        readerList.add(new DocxReader());
        readerList.add(new PDFReader());
        readerList.add(new DocReader());
        return readerList;
    }
}

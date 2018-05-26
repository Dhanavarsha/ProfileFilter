package fileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputFileGenerator {
    public static void writeToFile(String nameOnFile, String profileInfo) {

        File directory = new File(getOutputFolderPath());
        if (!directory.exists()) {
            directory.mkdir();
        }
        File file = new File(directory + "/" + getOutputFileName(nameOnFile));
        try {
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(profileInfo);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getOutputFileName(String nameOnFile) {
        return "DONE_" + nameOnFile + "_" + getTimeStamp() + ".txt";
    }

    private static String getTimeStamp() {
        return new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(new Date());
    }

    private static String getOutputFolderPath() {
        return System.getProperty("user.dir") + "/target/selectedProfiles/";
    }
}

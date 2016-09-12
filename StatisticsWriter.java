import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StatisticsWriter extends FileUser {

    protected enum Result {
        mastered, faulted, failed
    }

    protected StatisticsWriter() {
        File statFile = new File(path);
        try {
            if (!statFile.exists()) {
                statFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void resetStatisticFiles() {
        writeDefaultStats();
    }

    protected void addToStats(String word, Result result) {

        int index = findIndexOfWordInFile(word);
        int type = getType(result);
        Path filepath = Paths.get(_StatPath);
        try {
            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(filepath, StandardCharsets.UTF_8));
            String line = fileContent.get(index);
            String[] split = line.split("\\s+");
            split[type] = Integer.toString((Integer.parseInt(split[type]) + 1));
            fileContent.set(index, split[0]+" "+split[1]+" "+split[2]+" "+split[3]);

            Files.write(filepath, fileContent, StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeDefaultStats() {
        BufferedReader br = getBr(_WordList);
        String line;
        try {
            // false so it overwrites each time
            BufferedWriter bw = new BufferedWriter(new FileWriter(_StatPath,false));
            while (br.ready()) {
                line = br.readLine();
                bw.write(line + " 0 0 0\n");
            }
            bw.close();
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private int findIndexOfWordInFile(String word) {
        BufferedReader br = getBr(_WordList);
        int i = 0;
        try {
            while (!(br.readLine()).equals(word)) {
                i++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return i;
    }

    private int getType(Result r) {
        switch (r) {
            case mastered: return 1;
            case faulted: return 2;
            case failed: return 3;
        }
        // dead code
        return -1;
    }

}

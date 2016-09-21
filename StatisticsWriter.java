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
        int levelIndex = findIndexOfLevelDeclaration(word);

        int type = getType(result);
        Path filepath = Paths.get(_StatPath);
        try {
            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(filepath, StandardCharsets.UTF_8));
            String line = fileContent.get(index);
            String[] split = line.split("\\s+");
            split[type] = Integer.toString((Integer.parseInt(split[type]) + 1));
            fileContent.set(index, split[0]+" "+split[1]+" "+split[2]+" "+split[3]);

            String levelLine = fileContent.get(levelIndex);
            String[] levelSplit = levelLine.split("\\s+");
            levelSplit[type] = Integer.toString((Integer.parseInt(levelSplit[type]) + 1));
            fileContent.set(levelIndex, levelSplit[0]+" "+levelSplit[1]+" "+levelSplit[2]+" "+levelSplit[3]);

            String totalLine = fileContent.get(0);
            String[] totalSplit = totalLine.split("\\s+");
            totalSplit[type] = Integer.toString((Integer.parseInt(totalSplit[type]) + 1));
            fileContent.set(0, totalSplit[0]+" "+totalSplit[1]+" "+totalSplit[2]+" "+totalSplit[3]);

            Files.write(filepath, fileContent, StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeDefaultStats() {
        BufferedReader br = getWordListBr();
        try {
            // false so it overwrites each time
            BufferedWriter bw = new BufferedWriter(new FileWriter(_StatPath,false));
            bw.write("%Level-0 0 0 0\n");
            String line;
            while (br.ready()) {
                if ((line=br.readLine()).startsWith("%")) {
                    String[] split = line.split("\\s+");
                    bw.write(split[0]+"-"+split[1]+" 0 0 0\n");
                } else {
                    bw.write(line + " 0 0 0\n");
                }
            }
            bw.close();
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private int findIndexOfWordInFile(String word) {
        BufferedReader br = getWordListBr();
        int i = 1;
        try {
            while (!(br.readLine()).equals(word)) {
                i++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return i;
    }

    private int findIndexOfLevelDeclaration(String word) {
        BufferedReader br = getWordListBr();
        int i=0;
        int lineIndex=0;
        String line;
        try {
            while (!(line=br.readLine()).equals(word)) {
                i++;
                if (line.startsWith("%")) {
                    lineIndex+=i;
                    i=0;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return lineIndex;
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

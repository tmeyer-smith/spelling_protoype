import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StatisticsReader extends FileUser {


    public String[][] getStatsForLevel(int level) {

        if (level == 0) {
            return getTotalStats();
        }
        return getLevelStats(level);

    }

    private String[][] getLevelStats(int level) {

        int[] numArray = WordListsManager.getNumOfWordsPerLevel();
        int numOfWordsToShow = numArray[level-1];

        String[][] statArray = new String[numOfWordsToShow][4];
        try {
            BufferedReader br = new BufferedReader(new FileReader(_StatPath));
            while ((br.ready())&&(!br.readLine().startsWith("%Level "+level))) {
                // loop until find desired level
            }
            String line;
            int count=0;
            while ((br.ready())&&(!(line=br.readLine()).startsWith("%Level"))) {
                String[] split = line.split("\\s+");
                if (split.length>3) {
                    for (int i=0; i<3; i++) {
                        statArray[count][3-i] = split[split.length-i-1];
                    }
                    String word = "";
                    for (int i=0; i<split.length-3; i++) {
                        word+= split[i] + " ";
                    }
                    statArray[count][0] = word;
                } else {
                    System.arraycopy(split, 0, statArray[count], 0, 4);
                }
                count++;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return statArray;
    }

    private String[][] getTotalStats() {

        int[] numArray = WordListsManager.getNumOfWordsPerLevel();
        int numOfWordsToShow=0;
        for (int i : numArray) {
            numOfWordsToShow+=i;
        }

        String[][] statArray = new String[numOfWordsToShow][4];
        String line;
        int count=0;

        try {
            BufferedReader br = new BufferedReader((new FileReader(_StatPath)));
            while (br.ready()) {
                if (!(line = br.readLine()).startsWith("%")) {
                    String[] split = line.split("\\s+");
                    if (split.length>3) {
                        for (int i=0; i<3; i++) {
                            statArray[count][3-i] = split[split.length-i-1];
                        }
                        String word = "";
                        for (int i=0; i<split.length-3; i++) {
                            word+= split[i] + " ";
                        }
                        statArray[count][0] = word;
                    } else {
                        System.arraycopy(split, 0, statArray[count], 0, 4);
                    }
                    count++;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return statArray;
    }

}

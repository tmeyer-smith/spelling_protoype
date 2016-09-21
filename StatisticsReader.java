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
                System.arraycopy(split, 0, statArray[count], 0, 4);
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
                    System.arraycopy(split, 0, statArray[count], 0, 4);
                    count++;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return statArray;
    }

}
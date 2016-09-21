import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StatisticsReader extends FileUser {

    private String[][] statArray;

    protected String[][] getStatsForLevel(int level) {

        if (level == 0) {
            return getTotalStats();
        }
        return getLevelStats(level);

    }

    private String[][] getLevelStats(int level) {

        int[] numArray = WordListsManager.getNumOfWordsPerLevel();
        int numOfWordsToShow = numArray[level-1];

        statArray = new String[numOfWordsToShow][4];
        try {
            BufferedReader br = new BufferedReader(new FileReader(_StatPath));
            while ((br.ready())&&(!br.readLine().startsWith("%Level-"+level))) {
                // loop until find desired level
            }
            String line;
            int count=0;
            while ((br.ready())&&(!(line=br.readLine()).startsWith("%Level"))) {
                writeToArray(line, count);
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

        statArray = new String[numOfWordsToShow][4];
        String line;
        int count=0;

        try {
            BufferedReader br = new BufferedReader((new FileReader(_StatPath)));
            while (br.ready()) {
                if (!(line = br.readLine()).startsWith("%")) {
                    writeToArray(line, count);
                    count++;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return statArray;
    }

    private void writeToArray(String line, int count) {
        String[] split = getLineSplit(line);
        System.arraycopy(split, 0, statArray[count], 0, 4);
    }

    private String[] getLineSplit(String line) {
        String[] split = line.split("\\s+");

        if (split.length>3) {
            String[] newSplit = new String[4];
            for (int i=0; i<3; i++) {
                newSplit[3-i] = split[split.length-i-1];
            }
            String word = "";
            for (int i=0; i<split.length-3; i++) {
                word+= split[i] + " ";
            }
            newSplit[0] = word;
            return newSplit;
        }
        return split;
    }

    protected int getWordsCorrectForLevel(int level) {

        if (level==0) {
            return getWordsCorrectTotal();
        }

        int wordsCorrect=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(_StatPath));
            while ((br.ready()) && (!br.readLine().startsWith("%Level-" + level))) {
                // loop until find desired level
            }
            String line;
            while ((br.ready())&&(!(line=br.readLine()).startsWith("%Level"))) {
                String[] split = getLineSplit(line);
                if ((!split[1].equals("0"))||(!split[2].equals("0"))) {
                    wordsCorrect+=1;
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return wordsCorrect;
    }

    private int getWordsCorrectTotal() {
        int wordsCorrect=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(_StatPath));
            String line;
            while (br.ready()) {
                if (!(line=br.readLine()).startsWith("%")) {
                    String[] split = line.split("\\s+");
                    if ((!split[1].equals("0")) || (!split[2].equals("0"))) {
                        wordsCorrect += 1;
                    }
                }
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return wordsCorrect;
    }

    private int getTotalAccuracy() {
        String line;
        try {
            BufferedReader br = new BufferedReader((new FileReader(_StatPath)));
            line = br.readLine();
            return accuracyCalculation(line);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return -1;

    }

    protected int getLevelAccuracy(int level) {

        if (level==0) {
            return getTotalAccuracy();
        }

        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(_StatPath));
            while ((br.ready())&&(!(line=br.readLine()).startsWith("%Level-"+level))) {
                // loop until find desired level
            }
            return accuracyCalculation(line);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return -1;
    }

    private int accuracyCalculation(String line) {

        int attemptsCorrect = 0;
        int attemptsTotal = 0;

        String[] split = line.split("\\s+");
        int[] stats = new int[3];
        for (int i=0; i<3; i++) {
            stats[i] = Integer.parseInt(split[i+1]);
        }

        attemptsCorrect+=stats[0];
        attemptsCorrect+=stats[1];

        attemptsTotal+=stats[0];
        attemptsTotal+=(stats[1]*2);
        attemptsTotal+=(stats[2]*2);

        if ((attemptsCorrect==0)||(attemptsTotal==0)) {
            return 0;
        }
        return (attemptsCorrect*100)/attemptsTotal;

    }




}

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordList extends FileUser {

    private static final int _testSize = 10;
    private static final int _numOfLevels = 11;
    private static int[] _numOfWordsPerLevel;

    protected WordList() {
        BufferedReader br = getWordListBr();
        _numOfWordsPerLevel = new int[_numOfLevels];

        try {
            br.readLine(); // skip to second line so ignores %Level 1 line
            for (int i=0; i<_numOfLevels; i++) {
                int count = 0;
                while ((br.ready())&&(!br.readLine().startsWith("%"))) {
                    count++;
                }
                _numOfWordsPerLevel[i] = count;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected int[] getNumOfWordsPerLevel() {
        return _numOfWordsPerLevel;
    }

    protected String[] getTestList(String levelString) {

        int level = Integer.parseInt(levelString);

        String[] quizWords = new String[_testSize];
        ArrayList<String> wordsInLevel = getLevelSubList(level);
        int[] indexes = getRandomIndexes(wordsInLevel.size());

        for (int i=0; i<quizWords.length; i++) {
            quizWords[i] = wordsInLevel.get(indexes[i]);
        }

        return quizWords;

    }

    private ArrayList<String> getLevelSubList (int level) {
        ArrayList<String> wordsInLevel = new ArrayList<>();
        BufferedReader br = getWordListBr();
        String line;
        try {
            do {
                line = br.readLine();
            } while (!line.equals("%Level "+level));

            while ((br.ready())&&(!(line=br.readLine()).startsWith("%"))) {
                wordsInLevel.add(line);
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return wordsInLevel;
    }

    private int[] getRandomIndexes(int numWordsInLevel) {
        int[] randomNumberArray = new int[_testSize];
        Random randomNumGen = new Random();
        randomNumberArray[0] = randomNumGen.nextInt(numWordsInLevel);
        boolean isUnique;

        for (int i=1; i<randomNumberArray.length; i++) {
            do {
                randomNumberArray[i] = randomNumGen.nextInt(numWordsInLevel);
                isUnique = true;
                for (int j=0; j<i; j++) {
                    if (randomNumberArray[j] == randomNumberArray[i]) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);
        }
        return randomNumberArray;
    }

}

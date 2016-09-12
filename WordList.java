import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordList {

    private static final int _testSize = 10;

    public static String[] getWordList(int level) {
        String[] quizWords = new String[_testSize];
        ArrayList<String> wordsInLevel = getLevelSubList(level);
        int[] indexes = getRandomIndexes(wordsInLevel.size());

        for (int i=0; i<quizWords.length; i++) {
            quizWords[i] = wordsInLevel.get(indexes[i]);
        }

        return quizWords;

    }

    private static ArrayList<String> getLevelSubList (int level) {
        ArrayList<String> wordsInLevel = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Resources/WordList/NZCER-spelling-lists.txt"));
            String line;
            do {
                line = br.readLine();
            } while (!line.equals("%Level "+level));

            while ((br.ready())&&(!(line=br.readLine()).startsWith("%"))) {
                wordsInLevel.add(line);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return wordsInLevel;
    }

    private static int[] getRandomIndexes(int numWordsInLevel) {
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


    /* Test */

//    public static void main(String[] args) {
//        String[] list = getWordList(11);
//        System.out.println(Arrays.toString(list));
//    }

}

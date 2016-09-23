//import java.util.Arrays;

import java.util.ArrayList;

public class WordListsManager {

    /** Make into a package with FileUser, WordList, StatisticsWriter, StatisticsReader */

    private static WordListsManager _wlm;
    private WordList _wordObject;
    private StatisticsWriter _statWriterObject;
    private StatisticsReader _statReaderObject;

    private ArrayList<ArrayList<String>> failedWords;

   // private static int[] numWordsPerLevel;

    private WordListsManager() {
        _wordObject = new WordList();
        _statWriterObject = new StatisticsWriter();
        _statReaderObject = new StatisticsReader();

        failedWords = new ArrayList<>();
        for (int i=0; i<11; i++) {
            failedWords.add(new ArrayList<>());
        }

    }

    private static WordListsManager getWlm() {
        if (_wlm==null) {
            _wlm = new WordListsManager();
        }
        return _wlm;
    }
    
    public static void initialise() {
        getWlm().setUpStatistics();
    }
    
    private void setUpStatistics() {
        _statWriterObject.resetStatisticFiles();
    }

    public static String[] getTestList(String level) {
        return getWlm()._wordObject.getTestList(level);
    }

    public static int getNumOfWordsInLevel(int level) {
    	int num = 0;
    	if (level==0) {
    		for (int i : getWlm()._wordObject.getNumOfWordsPerLevel()) {
    			num+=i;
    		}
    		return num;
    	}
        return getWlm()._wordObject.getNumOfWordsPerLevel()[level-1];
    }

    public static void addMasteredWordStat(String word) {
        editFailedWords(word, 0);
        getWlm()._statWriterObject.addToStats(word, StatisticsWriter.Result.mastered);
    }
    public static void addFaultedWordStat(String word) {
        editFailedWords(word, 0);
        getWlm()._statWriterObject.addToStats(word, StatisticsWriter.Result.faulted);
    }
    public static void addFailedWordStat(String word) {
        editFailedWords(word, 1);
        getWlm()._statWriterObject.addToStats(word, StatisticsWriter.Result.failed);
    }
    public static void clearStatistics() {
        getWlm()._statWriterObject.resetStatisticFiles();
    }

    public static String[][] getStatsForLevel(int level) {
        return getWlm()._statReaderObject.getStatsForLevel(level);
    }
    public static int getAccuracyForLevel(int level) {
        return getWlm()._statReaderObject.getLevelAccuracy(level);
    }
    public static int getNumWordsCorrectForLevel(int level) {
        return getWlm()._statReaderObject.getWordsCorrectForLevel(level);
    }
    protected static int[] getNumOfWordsPerLevel() {
    	return getWlm()._wordObject.getNumOfWordsPerLevel();
    }

    private static void editFailedWords(String word, int result) {
        int level = getWlm()._wordObject.getLevelOfWord(word);
        if (result==0) {
            getWlm().failedWords.get(level-1).remove(word);
        } else {
            if (!getWlm().failedWords.get(level-1).contains(word)) {
                getWlm().failedWords.get(level - 1).add(word);
            }
        }
    }

}

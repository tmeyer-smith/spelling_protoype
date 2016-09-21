import java.util.Arrays;

public class WordListsManager {

    /** Make into a package with FileUser, WordList, StatisticsWriter, StatisticsReader */

    private static WordListsManager _wlm;
    private WordList _wordObject;
    private StatisticsWriter _statWriterObject;
    private StatisticsReader _statReaderObject;

    private static int[] numWordsPerLevel;

    private WordListsManager() {
        _wordObject = new WordList();
        _statWriterObject = new StatisticsWriter();
        _statReaderObject = new StatisticsReader();
        numWordsPerLevel = _wordObject.getNumOfWordsPerLevel();
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

    public static int[] getNumOfWordsPerLevel() {
        return getWlm()._wordObject.getNumOfWordsPerLevel();
    }

    public static void addMasteredWordStat(String word) {
        getWlm()._statWriterObject.addToStats(word, StatisticsWriter.Result.mastered);
    }
    public static void addFaultedWordStat(String word) {
        getWlm()._statWriterObject.addToStats(word, StatisticsWriter.Result.faulted);
    }
    public static void addFailedWordStat(String word) {
        getWlm()._statWriterObject.addToStats(word, StatisticsWriter.Result.failed);
    }
    public static void clearStatistics() {
        getWlm()._statWriterObject.resetStatisticFiles();
    }

    public static String[][] getStatsForLevel(String level) {
        int levelInt = Integer.parseInt(level);
        return getWlm()._statReaderObject.getStatsForLevel(levelInt);
    }
    public static int getAccuracyForLevel(String level) {
        int levelInt = Integer.parseInt(level);
        return getWlm()._statReaderObject.getLevelAccuracy(levelInt);
    }
    public static int getNumWordsCorrectForLevel(String level) {
        int levelInt = Integer.parseInt(level);
        return getWlm()._statReaderObject.getWordsCorrectForLevel(levelInt);
    }

    public static void main(String[] args) {

        WordListsManager.initialise();

        WordListsManager.addFailedWordStat("we");
        WordListsManager.addFailedWordStat("a");
        WordListsManager.addMasteredWordStat("to");
        WordListsManager.addFaultedWordStat("went");

        System.out.println(WordListsManager.getAccuracyForLevel("0"));
        System.out.println(WordListsManager.getNumWordsCorrectForLevel("1"));

    }

}

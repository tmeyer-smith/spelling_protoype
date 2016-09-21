import java.util.Arrays;

public class WordListsManager {

    /** Make into a package with FileUser, WordList, StatisticsWriter, StatisticsReader */

    private static WordListsManager _wlm;
    private WordList _wordObject;
    private StatisticsWriter _statWriterObject;
    private StatisticsReader _statReaderObject;

    private WordListsManager() {
        _wordObject = new WordList();
        _statWriterObject = new StatisticsWriter();
        _statReaderObject = new StatisticsReader();
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
    public static String[][] getStatsForLevel(int level) {
        return getWlm()._statReaderObject.getStatsForLevel(level);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(WordListsManager.getTestList("11")));

    }

}

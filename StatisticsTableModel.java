
public class StatisticsTableModel {

    private String _word;
    private int _mastered;
    private int _faulted;
    private int _failed;

    public StatisticsTableModel(String word, int masteredStat, int faultedStat, int failedStat) {
        _word = word;
        _mastered = masteredStat;
        _faulted = faultedStat;
        _failed = failedStat;
    }

}

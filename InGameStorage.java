import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class InGameStorage {

    protected String _font = "Dialog";

    private String[] _wordList;
    private String[] _finalAttempts;

    private ArrayList<CorrectWordDisplayLabel> feedbackWordLabels;
    private ArrayList<JLabel> numberLabels;


    public InGameStorage(String[] wordList) {

        _wordList = wordList;

        feedbackWordLabels = new ArrayList<>();
        numberLabels = new ArrayList<>();

        int wordDisplayHeight = 40;

        int xBound = 71;
        int[] yBounds = {193, 244, 295, 346, 397, 448, 499, 550, 601, 652};

        for (int i=0; i<10; i++) {
            CorrectWordDisplayLabel label = new CorrectWordDisplayLabel();
            label.setBounds(xBound, yBounds[i], 190, wordDisplayHeight);
            label.setText(wordList[i]);
            feedbackWordLabels.add(label);
        }


        for (int i=0; i<10; i++) {
            JLabel label = new JLabel("("+(i+1)+")");
            label.setForeground(Color.WHITE);
            label.setBackground(Color.BLACK);
            label.setFont(new Font(_font, Font.BOLD, 20));
            label.setHorizontalAlignment(SwingConstants.TRAILING);
            label.setOpaque(true);
            label.setBounds(21, yBounds[i], wordDisplayHeight, wordDisplayHeight);
            numberLabels.add(label);
        }


    }

    public String[] getTestList() {
        return _wordList;
    }

    public void setTestList(String[] list) {
        _wordList = list;
    }

    public void setFinalAttempts(String[] list) {
        _finalAttempts = list;
    }


    public void updateFeedbackLabels(int index, String attempt) {
        feedbackWordLabels.get(index).setText(attempt);
    }




    public ArrayList<CorrectWordDisplayLabel> getFeedbackWordLabels() {
        return feedbackWordLabels;
    }

    public ArrayList<JLabel> getNumberLabels() {
        return numberLabels;
    }

}

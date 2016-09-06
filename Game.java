

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game {

    private static SpellingFrame _frame;

    private static void setUpFrame() {
        JFrame _frame = new SpellingFrame();
        _frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        _frame.setVisible(true);
    }

    public static void main(String[] args) {
        setUpFrame();
    }

    public static void clearFrame() {
        _frame.removeAll();
    }

    public static void addToFrame(GameState gs) {
        _frame.add(gs);
    }



}

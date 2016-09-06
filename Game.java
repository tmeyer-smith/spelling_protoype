

import javax.swing.JFrame;

public class Game {

    private static SpellingFrame _frame;

    private static void setUpFrame() {
        _frame = new SpellingFrame();
    }

    public static void main(String[] args) {
        setUpFrame();
        GameStateManager.initializeGSM();
    }

    public static void clearFrame() {
        _frame.removeAll();
    }

    public static void addToFrame(GameStatePanel gs) {
    	_frame.setContentPane(gs);
    }



}

public class Game {

    private static SpellingFrame _frame;

    private static void setUpFrame() {
        _frame = new SpellingFrame();
    }

    public static void main(String[] args) {
        setUpFrame();
        GameStateManager.initializeGSM();
        _frame.setVisible(true);
    }

    public static void addToFrame(GameStatePanel gs) {
    	_frame.setContentPane(gs);
    	_frame.repaint();
    	_frame.revalidate();
    }



}

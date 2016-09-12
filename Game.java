
public class Game {

    private static SpellingFrame _frame;


    public static void main(String[] args) {
        setUpFrame();
        WordListsManager.initialise();
        GameStateManager.initialiseGSM();
    }

    private static void setUpFrame() {
        _frame = new SpellingFrame();
    }

    public static void addToFrame(GameStatePanel gs) {
        _frame.setContentPane(gs);
    }

}

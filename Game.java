
public class Game {

    private static SpellingFrame _frame;


    public static void main(String[] args) {
        setUpFrame();
    }

    private static void setUpFrame() {
        _frame = new SpellingFrame();
    }

    public static void clearFrame() {
        _frame.removeAll();
    }

    public static void addToFrame(GameStatePanel gs) {
        _frame.add(gs);
    }



}

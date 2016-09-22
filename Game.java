import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Game {

    private static SpellingFrame _frame;

    private static void setUpFrame() {
        _frame = new SpellingFrame();
    }

    public static void main(String[] args) { 	
        setUpFrame();
        GameStateManager.initializeGSM();
        WordListsManager.initialise();
        _frame.setVisible(true);
    }

    public static void addToFrame(GameStatePanel gs) {
    	_frame.setContentPane(gs);
    	_frame.repaint();
    	_frame.revalidate();
    }

}

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Game {

    private static SpellingFrame _frame;

    public static void main(String[] args) {
        addVLCLibrary();
        setUpFrame();
        WordListsManager.initialise();
        GameStateManager.initialiseGSM();
        VideoPanel vp = new VideoPanel();
        _frame.setContentPane(vp);
    }

    private static void setUpFrame() {
        _frame = new SpellingFrame();
    }

    public static void addToFrame(GameStatePanel gs) {
        _frame.setContentPane(gs);
    }

    private static void addVLCLibrary() {
        NativeLibrary.addSearchPath("vlc", "/Applications/VLC.app/Contents/MacOS/lib");
        //System.setProperty("jna.library.path", "/Applications/VLC.app/Contents/MacOS/lib");
        Native.loadLibrary("vlc", LibVlc.class);
    }

}

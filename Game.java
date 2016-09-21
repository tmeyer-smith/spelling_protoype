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
        _frame.setVisible(true);
        GameStateManager.initializeGSM();
        WordListsManager.initialise();
        addVLCLibrary();
        _frame.repaint();
        _frame.revalidate();
        
        VideoRewardState a = (VideoRewardState)_frame.getContentPane();
        a.getVideoPanel().startVideo();
    }

    public static void addToFrame(GameStatePanel gs) {
    	_frame.setContentPane(gs);
    	_frame.repaint();
    	_frame.revalidate();
    }


    private static void addVLCLibrary() {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "/usr/bin");
        //System.setProperty("jna.library.path", "/Applications/VLC.app/Contents/MacOS/lib");
        Native.loadLibrary("vlc", LibVlc.class);
    }


}

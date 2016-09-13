import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class SpellingFrame extends JFrame {

    private static final int _width = 1200;
    private static final int _height = 800;

    public SpellingFrame() {
        setTitle("Spelling Aid");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setSize(_width, _height);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game {

    private static final int _width = 500;
    private static final int _height = 500;
    private static JFrame _frame;

    private static void setUpFrame() {
        _frame = new JFrame("Spelling Aid");
        _frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        _frame.setSize(_width, _height);
        _frame.setLocationRelativeTo(null);
        _frame.setResizable(false);
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

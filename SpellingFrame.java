import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class SpellingFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the panel.
	 */
	public SpellingFrame() {
		setTitle("Spelling Aid");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		setResizable(false);
		setVisible(true);
	}


}

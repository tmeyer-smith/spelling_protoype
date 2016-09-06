import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class SpellingFrame extends JFrame {

	private GameState gs;
	private JPanel contentPane;
	
	/**
	 * Create the panel.
	 */
	public SpellingFrame() {
		loadMainMenu();
	}



	public void loadMainMenu() {

		setResizable(false);
		setTitle("Spelling Aid");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 0, 0));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMainMenu = new JLabel("MAIN MENU");
		lblMainMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMainMenu.setForeground(Color.WHITE);
		lblMainMenu.setBackground(Color.WHITE);
		lblMainMenu.setBounds(145, 0, 160, 80);
		contentPane.add(lblMainMenu);
	}


}

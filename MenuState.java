import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuState extends GameStatePanel {

	MenuState() {
		setBounds(new Rectangle(0, 0, 0, 0));
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel lblMainMenu = new JLabel("MAIN MENU");
		lblMainMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMainMenu.setForeground(Color.WHITE);
		lblMainMenu.setBackground(Color.WHITE);
		lblMainMenu.setBounds(521, 42, 160, 80);
		add(lblMainMenu);
	}
	
	
}



import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GameStatePanel extends JPanel {
	
	protected void setupBackground(String title) {
		setBounds(new Rectangle(0, 0, 1200, 800));
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel lblSettings = new JLabel(title);
		lblSettings.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setFont(new Font("Calibri", Font.BOLD, 90));
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setBackground(Color.WHITE);
		lblSettings.setBounds(350, 10, 500, 200);
		add(lblSettings);
		
		if (title!="MENU") {
			BackToMenuButton btnMainMenu = new BackToMenuButton();
			add(btnMainMenu);
		}
	}
	
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GameStatePanel extends JPanel {
	
	protected String _font = "SansSerif";
	
	protected void setupBackground(String title) {
		setBounds(new Rectangle(0, 0, 1200, 800));
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font(_font, Font.BOLD, 90));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setBounds(300, 10, 600, 200);
		lblTitle.setFocusable(false);
		add(lblTitle);
		
		if (title!="MENU") {
			BackToMenuButton btnMainMenu = new BackToMenuButton();
			add(btnMainMenu);
		}
	}
}
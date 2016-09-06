import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SettingsState extends GameStatePanel {

	/**
	 * Create the panel.
	 */
	public SettingsState() {
		setBounds(new Rectangle(0, 0, 1200, 800));
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel lblSettings = new JLabel("SETTINGS");
		lblSettings.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setFont(new Font("Calibri", Font.BOLD, 75));
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setBackground(Color.WHITE);
		lblSettings.setBounds(350, 10, 500, 200);
		add(lblSettings);
	}

}

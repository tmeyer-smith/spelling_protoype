import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CorrectWordDisplayLabel extends JLabel {

	CorrectWordDisplayLabel() {
		setHorizontalAlignment(SwingConstants.CENTER);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVisible(true);
		setOpaque(true);
		setFont(new Font("Calibri", Font.PLAIN, 20));
		setBackground(Color.RED);
	}

}

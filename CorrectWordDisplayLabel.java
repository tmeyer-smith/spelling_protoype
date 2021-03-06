import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CorrectWordDisplayLabel extends JLabel {

	CorrectWordDisplayLabel() {
		setHorizontalAlignment(SwingConstants.CENTER);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVisible(false);
		setOpaque(true);
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setBackground(Color.RED);
	}

}
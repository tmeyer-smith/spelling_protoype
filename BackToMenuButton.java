import java.awt.Font;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class BackToMenuButton extends ChangeStateButton {

    public BackToMenuButton() {
    	super(GameStateManager.State.menu);
        setup();
    }

    private void setup() {
        setText("Return to Menu");
		setFont(new Font("Dialog", Font.BOLD, 25));
		setBounds(10, 11, 295, 50);
    }

}
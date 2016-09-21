import javax.swing.*;
import java.awt.*;

public class ExitVideoRewardButton extends ChangeStateButton {

    public ExitVideoRewardButton() {
        super(GameStateManager.State.postgame);
        setup();
    }

    private void setup() {
        setText("Return to Menu");
        //setIcon(new ImageIcon("C:\\Users\\Tim\\Pictures\\leftArrow.png"));
        setFont(new Font("Calibri", Font.BOLD, 30));
        setBounds(10, 11, 295, 50);
    }

}

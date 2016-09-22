import java.awt.Font;

@SuppressWarnings("serial")
public class ExitVideoRewardButton extends ChangeStateButton {

    public ExitVideoRewardButton() {
        super(GameStateManager.State.postgame);
        setup();
    }

    private void setup() {
        setText("Return");
        setFont(new Font("Dialog", Font.BOLD, 30));
        setBounds(10, 11, 295, 50);
    }

}
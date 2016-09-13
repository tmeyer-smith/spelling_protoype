
public class BackToMenuButton extends ChangeStateButton {

    public BackToMenuButton() {
        super(GameStateManager.State.menu);
        setup();
    }

    private void setup() {
        setText("Back to Menu");
    }

}


public class BackToMenuButton extends ChangeStateButton {

    public BackToMenuButton() {
        super(GameStateManager.States.menu);
        setup();
    }

    private void setup() {
        setText("Back to Menu");
    }

}

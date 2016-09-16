
@SuppressWarnings("serial")
public class StartGameButton extends ChangeStateButton {

    public StartGameButton() {
        super(GameStateManager.State.play);
        setup();
    }

    private void setup() {
        setText("START GAME");
    }

}


@SuppressWarnings("serial")
public class NewGameButton extends ChangeStateButton {

    public NewGameButton() {
        super(GameStateManager.State.pregame);
        setup();
    }

    private void setup() {
        setText("PLAY");
    }

}


public class NewGameButton extends ChangeStateButton {

    public NewGameButton() {
        super(GameStateManager.States.pregame);
        setup();
    }

    private void setup() {
        setText("New Game");
    }

}

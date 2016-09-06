
public class SettingsButton extends ChangeStateButton {

    public SettingsButton() {
        super(GameStateManager.States.settings);
        setup();
    }

    private void setup() {
        setText("Settings");
    }

}

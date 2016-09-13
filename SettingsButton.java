
public class SettingsButton extends ChangeStateButton {

    public SettingsButton() {
        super(GameStateManager.State.settings);
        setup();
    }

    private void setup() {
        setText("Settings");
    }

}

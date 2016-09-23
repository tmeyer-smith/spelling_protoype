
public class StartReviewButton extends ChangeStateButton {

    public StartReviewButton() {
        super(GameStateManager.State.play);
        setup();
    }

    private void setup() {
        setText("REVIEW MISTAKES");
    }

}

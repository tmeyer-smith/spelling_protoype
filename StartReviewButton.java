
public class StartReviewButton extends ChangeStateButton {

    public StartReviewButton() {
        super(GameStateManager.State.review);
        setup();
    }

    private void setup() {
        setText("REVIEW MISTAKES");
    }

}

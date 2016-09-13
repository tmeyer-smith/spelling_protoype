
public class StatisticsButton extends ChangeStateButton {

    public StatisticsButton() {
        super(GameStateManager.State.statistics);
        setup();
    }

    private void setup() {
        setText("Statistics");
    }

}

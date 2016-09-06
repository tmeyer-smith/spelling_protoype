
public class StatisticsButton extends ChangeStateButton {

    public StatisticsButton() {
        super(GameStateManager.States.statistics);
        setup();
    }

    private void setup() {
        setText("Statistics");
    }

}

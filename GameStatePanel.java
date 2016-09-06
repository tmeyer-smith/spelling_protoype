import javax.swing.*;

abstract class GameStatePanel extends JPanel {

    public void stopState() {
        Game.clearFrame();
    }

}

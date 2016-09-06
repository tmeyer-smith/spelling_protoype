

import javax.swing.*;

@SuppressWarnings("serial")
abstract class GameStatePanel extends JPanel {

    public void stopState() {
        Game.clearFrame();
    }

}

import javax.swing.*;

abstract class GameState extends JPanel {

    public void stopState() {
        Game.clearFrame();
    }

}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class ChangeStateButton extends JButton {

    protected ChangeStateButton(GameStateManager.States nextState) {
        super();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameStateManager.changeState(nextState);
            }
        });
    }

}

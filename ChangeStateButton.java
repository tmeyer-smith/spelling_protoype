import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public abstract class ChangeStateButton extends JButton {

    protected ChangeStateButton(GameStateManager.State nextState) {
    	setFocusable(false);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameStateManager.changeState(nextState);
            }
        });
    }
    
}

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PostGameState extends GameStatePanel {

	/**
	 * Create the panel.
	 */
	public PostGameState() {
		super.setupBackground("POSTGAME");
		
		
		
		// needs to be made invisible
		JButton btnStatistics = new JButton("VIDEO REWARD");
		btnStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameStateManager.changeState(GameStateManager.State.videoReward);
            }
        });
		btnStatistics.setBounds(1000, 400, 100, 60);
		btnStatistics.setFont(new Font(_font, Font.BOLD, 15));
		add(btnStatistics);
		
	}

}

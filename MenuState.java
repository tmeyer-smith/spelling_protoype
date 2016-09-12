import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuState extends GameStatePanel {

	MenuState() {
		super.setupBackground("MENU");
		
		NewGameButton btnPlayGame = new NewGameButton();
		btnPlayGame.setFont(new Font("Calibri", Font.BOLD, 50));
		btnPlayGame.setBounds(425, 250, 350, 200);
		add(btnPlayGame);
		
		JButton btnStatistics = new JButton("STATISTICS");
		btnStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameStateManager.changeState(GameStateManager.State.statistics);
            }
        });
		btnStatistics.setBounds(350, 550, 200, 120);
		btnStatistics.setFont(new Font("Calibri", Font.BOLD, 30));
		add(btnStatistics);
		
		JButton btnSettings = new JButton("SETTINGS");
		btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameStateManager.changeState(GameStateManager.State.settings);
            }
        });
		btnSettings.setBounds(650, 550, 200, 120);
		btnSettings.setFont(new Font("Calibri", Font.BOLD, 30));
		add(btnSettings);
		
		
	}
	
	
}

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class PreGameState extends GameStatePanel {

	/**
	 * Create the panel.
	 */
	public PreGameState() {
		super.setupBackground("PREGAME");
		
		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> dropDown = (JComboBox<String>)e.getSource();
				String chosenLevel = (String) dropDown.getSelectedItem();
				GameStateManager.setLevel(chosenLevel.substring(6));
			}
		}
				);

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Level 11", "Level 10", "Level 9", "Level 8",
				"Level 7", "Level 6", "Level 5", "Level 4", "Level 3", "Level 2", "Level 1"}));
		comboBox.setBounds(870, 243, 161, 20);
		add(comboBox);
		
		
		
		StartGameButton btnPlayGame = new StartGameButton();
		btnPlayGame.setFont(new Font("Calibri", Font.BOLD, 50));
		btnPlayGame.setBounds(425, 250, 350, 200);
		add(btnPlayGame);
		
	}

}

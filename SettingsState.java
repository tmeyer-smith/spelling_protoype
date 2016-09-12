import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SettingsState extends GameStatePanel {

	private JCheckBox chckbxResetStatistics;
	private JComboBox<String> voiceDropDown;
	private JLabel lblAnyUnsavedChanges;

	/**
	 * Create the panel.
	 */
	public SettingsState() {
		
		JButton btnSaveSettings = new JButton("SAVE SETTINGS");
		btnSaveSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveSettings();
			}
		}	
				);

		
		
		btnSaveSettings.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSaveSettings.setBounds(493, 616, 181, 86);
		add(btnSaveSettings);
		
		voiceDropDown = new JComboBox<String>();
		voiceDropDown.setBounds(157, 281, 158, 27);
		add(voiceDropDown);
		
		chckbxResetStatistics = new JCheckBox("Reset Statistics - This will delete all the statistics generated so far");
		chckbxResetStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unsavedMessageActivate();
			}
		}	
				);
		chckbxResetStatistics.setFont(new Font("Calibri", Font.BOLD, 20));
		chckbxResetStatistics.setBackground(Color.BLACK);
		chckbxResetStatistics.setForeground(Color.WHITE);
		chckbxResetStatistics.setBounds(157, 378, 679, 41);
		chckbxResetStatistics.isSelected();
		add(chckbxResetStatistics);
		
		JLabel lblReadingVoice = new JLabel("Reading Voice - Choose which voice, you would like to be used in Play mode");
		lblReadingVoice.setFont(new Font("Calibri", Font.BOLD, 20));
		lblReadingVoice.setForeground(Color.WHITE);
		lblReadingVoice.setLabelFor(voiceDropDown);
		lblReadingVoice.setBounds(157, 222, 679, 48);
		add(lblReadingVoice);
		
		JLabel lblResetStatistics = new JLabel("This includes your failed words and will make review mode unplayable");
		lblResetStatistics.setForeground(Color.WHITE);
		lblResetStatistics.setFont(new Font("Calibri", Font.BOLD, 20));
		lblResetStatistics.setBounds(320, 411, 603, 48);
		add(lblResetStatistics);
		
		lblAnyUnsavedChanges = new JLabel("Any unsaved changes will be lost");
		lblAnyUnsavedChanges.setVisible(false);
		lblAnyUnsavedChanges.setForeground(Color.WHITE);
		lblAnyUnsavedChanges.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAnyUnsavedChanges.setBounds(23, 68, 276, 48);
		add(lblAnyUnsavedChanges);
		
		super.setupBackground("SETTINGS");
		
		
	}
	
	protected void unsavedMessageActivate() {
		lblAnyUnsavedChanges.setVisible(true);
	}

	private void saveSettings() {
		if(chckbxResetStatistics.isSelected()) {
			resetStatistics();
		}
		
		if(!GameStateManager.getGSM().getVoice().equals((String)voiceDropDown.getSelectedItem())) {
			GameStateManager.changeVoice((String)voiceDropDown.getSelectedItem());
		}
		
	}

	private void resetStatistics() {
		// TODO Auto-generated method stub
		
	}
}

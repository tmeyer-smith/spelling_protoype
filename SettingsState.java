import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

/**
 * @author Tim
 *
 */

@SuppressWarnings("serial")
public class SettingsState extends GameStatePanel {

	private JCheckBox chckbxResetStatistics;
	private JComboBox<String> voiceDropDown;
	private JLabel lblAnyUnsavedChanges;

	/**
	 * Create the panel.
	 */
	public SettingsState() {
		
		lblAnyUnsavedChanges = new JLabel("Any unsaved changes will be lost");
		lblAnyUnsavedChanges.setFocusable(false);
		lblAnyUnsavedChanges.setVisible(false);
		lblAnyUnsavedChanges.setForeground(Color.WHITE);
		lblAnyUnsavedChanges.setFont(new Font(_font, Font.BOLD, 20));
		lblAnyUnsavedChanges.setBounds(23, 68, 276, 48);
		add(lblAnyUnsavedChanges);
		
		final JButton btnSaveSettings = new JButton("SAVE SETTINGS");
		btnSaveSettings.setFocusable(false);
		btnSaveSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveSettings();
				btnSaveSettings.setEnabled(false);
				lblAnyUnsavedChanges.setVisible(false);
			}
		}	
				);

		btnSaveSettings.setFont(new Font(_font, Font.PLAIN, 20));
		btnSaveSettings.setBounds(493, 616, 181, 86);
		btnSaveSettings.setEnabled(false);
		add(btnSaveSettings);
		
		
		
		voiceDropDown = new JComboBox<String>();
		voiceDropDown.setFocusable(false);
		voiceDropDown.setModel(new DefaultComboBoxModel<String>(new String[] {"Voice 1", "Voice 2", "Voice 3"}));
		voiceDropDown.setBounds(157, 281, 158, 27);
		voiceDropDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblAnyUnsavedChanges.setVisible(true);
				btnSaveSettings.setEnabled(true);
			}
		}	
				);
		add(voiceDropDown);
		
		chckbxResetStatistics = new JCheckBox("Reset Statistics - This will delete all the statistics generated so far");
		chckbxResetStatistics.setFocusable(false);
		chckbxResetStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblAnyUnsavedChanges.setVisible(true);
				btnSaveSettings.setEnabled(true);
				chckbxResetStatistics.setSelected(false);
			}
		}	
				);
		chckbxResetStatistics.setFont(new Font(_font, Font.BOLD, 20));
		chckbxResetStatistics.setBackground(Color.BLACK);
		chckbxResetStatistics.setForeground(Color.WHITE);
		chckbxResetStatistics.setBounds(157, 378, 679, 41);
		chckbxResetStatistics.isSelected();
		add(chckbxResetStatistics);
		
		JLabel lblReadingVoice = new JLabel("Reading Voice - Choose which voice, you would like to be used in Play mode");
		lblReadingVoice.setFocusable(false);
		lblReadingVoice.setFont(new Font(_font, Font.BOLD, 20));
		lblReadingVoice.setForeground(Color.WHITE);
		lblReadingVoice.setLabelFor(voiceDropDown);
		lblReadingVoice.setBounds(157, 222, 679, 48);
		add(lblReadingVoice);
		
		JLabel lblResetStatistics = new JLabel("This includes your failed words and will make review mode unplayable");
		lblResetStatistics.setFocusable(false);
		lblResetStatistics.setForeground(Color.WHITE);
		lblResetStatistics.setFont(new Font(_font, Font.BOLD, 20));
		lblResetStatistics.setBounds(320, 411, 603, 48);
		add(lblResetStatistics);
		
		
		
		super.setupBackground("SETTINGS");
		
		
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
		
	}
}
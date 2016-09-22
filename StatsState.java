import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class StatsState extends GameStatePanel {

	private JTable _statsTable ;
	private JLabel accuracyNum;
	private JLabel correctStat;
	/**
	 * Create the panel.
	 */
	public StatsState() {
		super.setupBackground("STATISTICS");
		
		_statsTable = new JTable();
		_statsTable.setAutoCreateRowSorter(true);
		_statsTable.setRowSelectionAllowed(false);
		_statsTable.setSelectionForeground(Color.WHITE);
		_statsTable.setBackground(Color.WHITE);
		_statsTable.setGridColor(Color.LIGHT_GRAY);
		_statsTable.setForeground(Color.BLACK);
		_statsTable.setRowHeight(37);

		_statsTable.setModel(new DefaultTableModel(
				WordListsManager.getStatsForLevel(0),
				new String[] {
						"Word", "Mastered", "Faulted", "Failed"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		_statsTable.setFont(new Font("Dialog", Font.BOLD, 18));
		_statsTable.setBounds(10, 118, 430, 258);
		setColumnWidths();
		
		
		JScrollPane scrollPane = new JScrollPane(_statsTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setFont(new Font("Dialog", Font.PLAIN, 20));
		scrollPane.setBounds(306, 243, 588, 385);
		_statsTable.setFillsViewportHeight(false);
		add(scrollPane);
		

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Dialog", Font.BOLD, 20));

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> dropDown = (JComboBox<String>)e.getSource();
				updateTable((String)dropDown.getSelectedItem());
				updateStats((String)dropDown.getSelectedItem());
			}
		}
				);

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"All Levels", "Level 11", "Level 10", "Level 9", "Level 8",
				"Level 7", "Level 6", "Level 5", "Level 4", "Level 3", "Level 2", "Level 1"}));
		comboBox.setBounds(950, 286, 185, 59);
		add(comboBox);
		
		JLabel accuracyLabel = new JLabel("Accuracy:");
		accuracyLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		accuracyLabel.setForeground(Color.WHITE);
		accuracyLabel.setBackground(Color.BLACK);
		accuracyLabel.setBounds(39, 289, 152, 53);
		add(accuracyLabel);
		
		JLabel lblWordsSpelt = new JLabel("Words Spelt");
		lblWordsSpelt.setForeground(Color.WHITE);
		lblWordsSpelt.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWordsSpelt.setBackground(Color.BLACK);
		lblWordsSpelt.setBounds(39, 339, 152, 53);
		add(lblWordsSpelt);
		
		JLabel lblCorrectly = new JLabel("Correctly:");
		lblCorrectly.setForeground(Color.WHITE);
		lblCorrectly.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCorrectly.setBackground(Color.BLACK);
		lblCorrectly.setBounds(39, 376, 113, 53);
		add(lblCorrectly);
		
		accuracyNum = new JLabel("");
		accuracyNum.setText(WordListsManager.getAccuracyForLevel(0)+"%");
		accuracyNum.setForeground(Color.WHITE);
		accuracyNum.setFont(new Font("Dialog", Font.BOLD, 20));
		accuracyNum.setBackground(Color.BLACK);
		accuracyNum.setBounds(164, 289, 124, 53);
		add(accuracyNum);
		
		correctStat = new JLabel("");
		int a = WordListsManager.getNumWordsCorrectForLevel(0);
		correctStat.setText(WordListsManager.getNumWordsCorrectForLevel(0)+"/"+
							WordListsManager.getNumOfWordsInLevel(0));
		correctStat.setForeground(Color.WHITE);
		correctStat.setFont(new Font("Dialog", Font.BOLD, 20));
		correctStat.setBackground(Color.BLACK);
		correctStat.setBounds(164, 376, 124, 53);
		add(correctStat);
		
		
	}
	
	
	private void updateTable(String level) {
		String[][] stats;
		if (level.equals("All Levels")) {
			stats = WordListsManager.getStatsForLevel(0);
		}
		else {
			stats = WordListsManager.getStatsForLevel(Integer.parseInt(level.substring(6)));
		}


		_statsTable.setModel(new DefaultTableModel( stats,
				new String[] {
						"Word", "Mastered", "Faulted", "Failed"
		}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		setColumnWidths();
	}
	
	private void updateStats(String level) {
		if (level.equals("All Levels")) {
			accuracyNum.setText(WordListsManager.getAccuracyForLevel(0)+"%");
			correctStat.setText(WordListsManager.getNumWordsCorrectForLevel(0)+"/"+
								WordListsManager.getNumOfWordsInLevel(0));
		}
		else {
			int lvl = Integer.parseInt(level.substring(6));
			accuracyNum.setText(WordListsManager.getAccuracyForLevel(lvl)+"%");
			correctStat.setText(WordListsManager.getNumWordsCorrectForLevel(lvl)+"/"+
					            WordListsManager.getNumOfWordsInLevel(lvl));
		}
		
		
	}
	
	
	private void setColumnWidths() {
		_statsTable.getColumnModel().getColumn(0).setPreferredWidth(210);
		_statsTable.getColumnModel().getColumn(0).setMinWidth(210);
		_statsTable.getColumnModel().getColumn(0).setMaxWidth(210);
		_statsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		_statsTable.getColumnModel().getColumn(1).setMinWidth(120);
		_statsTable.getColumnModel().getColumn(1).setMaxWidth(120);
		_statsTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		_statsTable.getColumnModel().getColumn(2).setMinWidth(120);
		_statsTable.getColumnModel().getColumn(2).setMaxWidth(120);
		_statsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		_statsTable.getColumnModel().getColumn(3).setMinWidth(120);
		_statsTable.getColumnModel().getColumn(3).setMaxWidth(120);
	}
	
}
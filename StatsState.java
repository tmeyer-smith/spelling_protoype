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

@SuppressWarnings("serial")
public class StatsState extends GameStatePanel {

	private JTable _statsTable ;
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
		_statsTable.setRowHeight(20);
		
		_statsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "2", null, null},
				{"3", "4", null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Word", "Mastered", "Faulted", "Failed"
			}
		) 
		{
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		_statsTable.getColumnModel().getColumn(0).setMinWidth(10);
		_statsTable.setFont(new Font("Calibri", Font.PLAIN, 15));
		_statsTable.setBounds(10, 118, 430, 258);
		
		JScrollPane scrollPane = new JScrollPane(_statsTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setFont(new Font("Calibri", Font.PLAIN, 15));
		scrollPane.setBounds(149, 243, 450, 350);
		_statsTable.setFillsViewportHeight(false);
		add(scrollPane);
		

		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> dropDown = (JComboBox<String>)e.getSource();
				updateTable((String)dropDown.getSelectedItem());
			}
		}
				);

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"All Levels", "Level 11", "Level 10", "Level 9", "Level 8",
				"Level 7", "Level 6", "Level 5", "Level 4", "Level 3", "Level 2", "Level 1"}));
		comboBox.setBounds(870, 243, 161, 20);
		add(comboBox);
		
		
	}
	
	
		protected void updateTable(String level) {
			_statsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "2", "5", null},
				{"3", "4", null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
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
		}
		

}

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PlayState extends GameStatePanel {
	private JTextField textField;
	private ArrayList<correctWordDisplayLabel> feedbackWordLabels;
	private int count;

	PlayState() {
		setBounds(new Rectangle(0, 0, 1200, 800));
		super.setupBackground("PLAY");
		
		count = 0;
		
		feedbackWordLabels = new ArrayList<correctWordDisplayLabel>();
		
		int wordDisplayHeight = 40;
		
		correctWordDisplayLabel lblWord1 = new correctWordDisplayLabel();
		lblWord1.setBounds(71, 193, 190, wordDisplayHeight);
		add(lblWord1);
		
		correctWordDisplayLabel lblWord2 = new correctWordDisplayLabel();
		lblWord2.setBounds(71, 244, 190, wordDisplayHeight);
		add(lblWord2);
		
		correctWordDisplayLabel lblWord3 = new correctWordDisplayLabel();
		lblWord3.setBounds(71, 295, 190, wordDisplayHeight);
		add(lblWord3);
		
		correctWordDisplayLabel lblWord4 = new correctWordDisplayLabel();
		lblWord4.setBounds(71, 346, 190, wordDisplayHeight);
		add(lblWord4);
		
		correctWordDisplayLabel lblWord5 = new correctWordDisplayLabel();
		lblWord5.setBounds(71, 397, 190, wordDisplayHeight);
		add(lblWord5);
		
		correctWordDisplayLabel lblWord6 = new correctWordDisplayLabel();
		lblWord6.setBounds(71, 448, 190, wordDisplayHeight);
		add(lblWord6);
		
		correctWordDisplayLabel lblWord7 = new correctWordDisplayLabel();
		lblWord7.setBounds(71, 499, 190, wordDisplayHeight);
		add(lblWord7);
		
		correctWordDisplayLabel lblWord8 = new correctWordDisplayLabel();
		lblWord8.setBounds(71, 550, 190, wordDisplayHeight);
		add(lblWord8);
		
		correctWordDisplayLabel lblWord9 = new correctWordDisplayLabel();
		lblWord9.setBounds(71, 601, 190, wordDisplayHeight);
		add(lblWord9);
		
		correctWordDisplayLabel lblWord10 = new correctWordDisplayLabel();
		lblWord10.setBounds(71, 652, 190, wordDisplayHeight);
		add(lblWord10);	
		
		feedbackWordLabels.add(lblWord1);
		feedbackWordLabels.add(lblWord2);
		feedbackWordLabels.add(lblWord3);
		feedbackWordLabels.add(lblWord4);
		feedbackWordLabels.add(lblWord5);
		feedbackWordLabels.add(lblWord6);
		feedbackWordLabels.add(lblWord7);
		feedbackWordLabels.add(lblWord8);
		feedbackWordLabels.add(lblWord9);
		feedbackWordLabels.add(lblWord10);
		
		
		textField = new JTextField();
		textField.setCaretColor(Color.WHITE);
		textField.setFont(new Font("Calibri", Font.PLAIN, 30));
		textField.setBounds(425, 387, 281, 77);
		textField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (textField.getText().length() >= 15 ) 
		            e.consume(); 
		    }  
		});
		textField.setColumns(10);
		add(textField);
		
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count>=20){
					return;
				}
				correctWordDisplayLabel currentLabel = feedbackWordLabels.get(count/2);
				currentLabel.setText(textField.getText());

				if(textField.getText().equals("correct")) {
					currentLabel.setBackground(Color.green);
					if(count%2==0){
						currentLabel.setVisible(true);
						count=count+2;
					}
					else {
						count++;
					}
				}
				else {
					currentLabel.setBackground(Color.red);
					if(count%2==0){
						currentLabel.setVisible(true);
					}
					count++;
				}
			}
		});
		
		
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(767, 387, 126, 77);
		add(btnSubmit);
		
		JLabel label_1 = new JLabel("(1)");
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(Color.BLACK);
		label_1.setFont(new Font("Calibri", Font.BOLD, 30));
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setOpaque(true);
		label_1.setBounds(21, 193, wordDisplayHeight, wordDisplayHeight);
		add(label_1);
		
		JLabel label_2 = new JLabel("(2)");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Calibri", Font.BOLD, 30));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(21, 244, wordDisplayHeight, wordDisplayHeight);
		add(label_2);
		
		JLabel label_3 = new JLabel("(3)");
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Calibri", Font.BOLD, 30));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(21, 295, wordDisplayHeight, wordDisplayHeight);
		add(label_3);
		
		JLabel label_4 = new JLabel("(4)");
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Calibri", Font.BOLD, 30));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(21, 346, wordDisplayHeight, wordDisplayHeight);
		add(label_4);
		
		JLabel label_5 = new JLabel("(5)");
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Calibri", Font.BOLD, 30));
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(21, 397, wordDisplayHeight, wordDisplayHeight);
		add(label_5);
		
		JLabel label_6 = new JLabel("(6)");
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Calibri", Font.BOLD, 30));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(21, 448, wordDisplayHeight, wordDisplayHeight);
		add(label_6);
		
		JLabel label_7 = new JLabel("(7)");
		label_7.setOpaque(true);
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Calibri", Font.BOLD, 30));
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(21, 499, wordDisplayHeight, wordDisplayHeight);
		add(label_7);
		
		JLabel label_8 = new JLabel("(8)");
		label_8.setOpaque(true);
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Calibri", Font.BOLD, 30));
		label_8.setBackground(Color.BLACK);
		label_8.setBounds(21, 550, wordDisplayHeight, wordDisplayHeight);
		add(label_8);
		
		JLabel label_9 = new JLabel("(9)");
		label_9.setOpaque(true);
		label_9.setHorizontalAlignment(SwingConstants.TRAILING);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Calibri", Font.BOLD, 30));
		label_9.setBackground(Color.BLACK);
		label_9.setBounds(21, 601, 40, 40);
		add(label_9);
		
		JLabel label_10 = new JLabel("(10)");
		label_10.setOpaque(true);
		label_10.setHorizontalAlignment(SwingConstants.TRAILING);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Calibri", Font.BOLD, 30));
		label_10.setBackground(Color.BLACK);
		label_10.setBounds(10, 652, 50, wordDisplayHeight);
		add(label_10);
		
		
		
	}
}
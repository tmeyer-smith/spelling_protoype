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
	private JTextField answerBox;
	private JButton submitButton;
	private ArrayList<CorrectWordDisplayLabel> feedbackWordLabels;
	private int count;
	private String[] wordList;

	PlayState() {
		setBounds(new Rectangle(0, 0, 1200, 800));
		super.setupBackground("PLAY");
		
		count = 0;
		
		wordList = WordListsManager.getTestList(GameStateManager.getLevel());
		feedbackWordLabels = new ArrayList<CorrectWordDisplayLabel>();
		
		int wordDisplayHeight = 40;
		
		CorrectWordDisplayLabel lblWord1 = new CorrectWordDisplayLabel();
		lblWord1.setBounds(71, 193, 190, wordDisplayHeight);
		lblWord1.setText(wordList[0]);
		add(lblWord1);
		
		CorrectWordDisplayLabel lblWord2 = new CorrectWordDisplayLabel();
		lblWord2.setBounds(71, 244, 190, wordDisplayHeight);
		lblWord1.setText(wordList[1]);
		add(lblWord2);
		
		CorrectWordDisplayLabel lblWord3 = new CorrectWordDisplayLabel();
		lblWord3.setBounds(71, 295, 190, wordDisplayHeight);
		lblWord1.setText(wordList[2]);
		add(lblWord3);
		
		CorrectWordDisplayLabel lblWord4 = new CorrectWordDisplayLabel();
		lblWord4.setBounds(71, 346, 190, wordDisplayHeight);
		lblWord1.setText(wordList[3]);
		add(lblWord4);
		
		CorrectWordDisplayLabel lblWord5 = new CorrectWordDisplayLabel();
		lblWord5.setBounds(71, 397, 190, wordDisplayHeight);
		lblWord1.setText(wordList[4]);
		add(lblWord5);
		
		CorrectWordDisplayLabel lblWord6 = new CorrectWordDisplayLabel();
		lblWord6.setBounds(71, 448, 190, wordDisplayHeight);
		lblWord1.setText(wordList[5]);
		add(lblWord6);
		
		CorrectWordDisplayLabel lblWord7 = new CorrectWordDisplayLabel();
		lblWord7.setBounds(71, 499, 190, wordDisplayHeight);
		lblWord1.setText(wordList[6]);
		add(lblWord7);
		
		CorrectWordDisplayLabel lblWord8 = new CorrectWordDisplayLabel();
		lblWord8.setBounds(71, 550, 190, wordDisplayHeight);
		lblWord1.setText(wordList[7]);
		add(lblWord8);
		
		CorrectWordDisplayLabel lblWord9 = new CorrectWordDisplayLabel();
		lblWord9.setBounds(71, 601, 190, wordDisplayHeight);
		lblWord1.setText(wordList[8]);
		add(lblWord9);
		
		CorrectWordDisplayLabel lblWord10 = new CorrectWordDisplayLabel();
		lblWord10.setBounds(71, 652, 190, wordDisplayHeight);
		lblWord1.setText(wordList[9]);
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

		
		submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CorrectWordDisplayLabel currentLabel = feedbackWordLabels.get(count/2);
				currentLabel.setText(answerBox.getText());
				String testWord = wordList[count/2];
				String upperCaseTestWord = testWord.toUpperCase();

				if(answerBox.getText().equals(upperCaseTestWord)) {
					currentLabel.setBackground(Color.green);
					if(count%2==0){
						WordListsManager.addMasteredWordStat(testWord);
						currentLabel.setVisible(true);
						count=count+2;
					}
					else {
						WordListsManager.addFaultedWordStat(testWord);
						count++;
					}
				}
				else {
					if (count%2==1) {
						WordListsManager.addFailedWordStat(testWord);
					}
					else {
						Festival.use("Incorrect try again. Spell the word: " + wordList[count/2]);
					}
					currentLabel.setBackground(Color.red);
					currentLabel.setVisible(true);
					count++;
				}
				
				// Read out next word if there is one
				if(count%2==0 && count <20 ) {
					Festival.use("Spell the word: " + wordList[count/2]);
				}
				
				if(count>=20){
					GameStateManager.changeState(GameStateManager.State.postgame);
				}
				
				submitButton.setEnabled(false);
				answerBox.setText("");
				answerBox.requestFocus();
				
			}
		});
		submitButton.setFont(new Font(_font, Font.BOLD, 20));
		submitButton.setBackground(Color.WHITE);
		submitButton.setBounds(767, 387, 126, 77);
		add(submitButton);
		
		
		
		answerBox = new JTextField();
		answerBox.setHorizontalAlignment(JTextField.CENTER);
		answerBox.setCaretColor(Color.WHITE);
		answerBox.setFont(new Font(_font, Font.PLAIN, 30));
		answerBox.setBounds(425, 387, 281, 77);
		answerBox.requestFocus();
		answerBox.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) { 
				submitButton.setEnabled(true);
				
				char letterTyped = e.getKeyChar();
				if (Character.isLowerCase(letterTyped)) {
					e.setKeyChar(Character.toUpperCase(letterTyped));
				}

				if (answerBox.getText().length() >= 15 ) 
					e.consume(); 
			}  
		});
		add(answerBox);
		
		
		JLabel label_1 = new JLabel("(1)");
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(Color.BLACK);
		label_1.setFont(new Font(_font, Font.BOLD, 20));
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setOpaque(true);
		label_1.setBounds(21, 193, wordDisplayHeight, wordDisplayHeight);
		add(label_1);
		
		JLabel label_2 = new JLabel("(2)");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font(_font, Font.BOLD, 20));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(21, 244, wordDisplayHeight, wordDisplayHeight);
		add(label_2);
		
		JLabel label_3 = new JLabel("(3)");
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font(_font, Font.BOLD, 20));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(21, 295, wordDisplayHeight, wordDisplayHeight);
		add(label_3);
		
		JLabel label_4 = new JLabel("(4)");
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font(_font, Font.BOLD, 20));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(21, 346, wordDisplayHeight, wordDisplayHeight);
		add(label_4);
		
		JLabel label_5 = new JLabel("(5)");
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font(_font, Font.BOLD, 20));
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(21, 397, wordDisplayHeight, wordDisplayHeight);
		add(label_5);
		
		JLabel label_6 = new JLabel("(6)");
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font(_font, Font.BOLD, 20));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(21, 448, wordDisplayHeight, wordDisplayHeight);
		add(label_6);
		
		JLabel label_7 = new JLabel("(7)");
		label_7.setOpaque(true);
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font(_font, Font.BOLD, 20));
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(21, 499, wordDisplayHeight, wordDisplayHeight);
		add(label_7);
		
		JLabel label_8 = new JLabel("(8)");
		label_8.setOpaque(true);
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font(_font, Font.BOLD, 20));
		label_8.setBackground(Color.BLACK);
		label_8.setBounds(21, 550, wordDisplayHeight, wordDisplayHeight);
		add(label_8);
		
		JLabel label_9 = new JLabel("(9)");
		label_9.setOpaque(true);
		label_9.setHorizontalAlignment(SwingConstants.TRAILING);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font(_font, Font.BOLD, 20));
		label_9.setBackground(Color.BLACK);
		label_9.setBounds(21, 601, 40, 40);
		add(label_9);
		
		JLabel label_10 = new JLabel("(10)");
		label_10.setOpaque(true);
		label_10.setHorizontalAlignment(SwingConstants.TRAILING);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font(_font, Font.BOLD, 20));
		label_10.setBackground(Color.BLACK);
		label_10.setBounds(10, 652, 50, wordDisplayHeight);
		add(label_10);
		
		
		
		JButton btnRepeatWord = new JButton("Repeat Word");
		btnRepeatWord.setBounds(472, 530, 200, 50);
		btnRepeatWord.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnRepeatWord.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count<20) {
					Festival.use(wordList[count/2]);
				}
			}
		});
		
		add(btnRepeatWord);
		
		
		Festival.use("Spell the word: " + wordList[count/2]); // Say the first word in the quiz
	}
}
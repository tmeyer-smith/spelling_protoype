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

	PlayState(InGameStorage storage) {
		setBounds(new Rectangle(0, 0, 1200, 800));
		super.setupBackground("PLAY");
		
		count = 0;

		wordList = storage.getTestList();


		feedbackWordLabels = storage.getFeedbackWordLabels();
		for (CorrectWordDisplayLabel label : feedbackWordLabels) {
			add(label);
		}


		
		submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CorrectWordDisplayLabel currentLabel = feedbackWordLabels.get(count/2);
				currentLabel.setText(answerBox.getText());
				storage.updateFeedbackLabels(count/2, answerBox.getText());
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
					GameStateManager.goToPostGame(storage);


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



		ArrayList<JLabel> numberLabels = storage.getNumberLabels();
		for (JLabel label : numberLabels) {
			add(label);
		}

		
		
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
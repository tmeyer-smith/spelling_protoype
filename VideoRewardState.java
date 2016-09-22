import javax.swing.JButton;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VideoRewardState extends GameStatePanel {

	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
	private final EmbeddedMediaPlayer video;
	private Boolean started;
	private JButton btnPausePlay;
	private ExitVideoRewardButton btnExitVideoReward;

	public VideoRewardState() {
		super.setupBackground("VIDEO REWARD");
		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		mediaPlayerComponent.setBounds(200, 250, 800, 400);
		add(mediaPlayerComponent);

		video = mediaPlayerComponent.getMediaPlayer();

		started =false;

		btnPausePlay = new JButton();
		btnPausePlay.setText("Play");
		btnPausePlay.setBounds(500, 700, 200, 100);
		btnPausePlay.setFont(new Font(_font, Font.BOLD, 15));
		btnPausePlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!started) {
					startVideo();
					started = true;
					btnPausePlay.setText("Pause");
				}
				else {
					if (btnPausePlay.getText().equals("Pause")) {
						video.pause();
						btnPausePlay.setText("Play");
					} else {
						video.play();
						btnPausePlay.setText("Pause");
					}
				}
			}
		});
		add(btnPausePlay);
		
		
		
		
		btnExitVideoReward = new ExitVideoRewardButton();
		btnExitVideoReward.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				video.stop();
			}
		});
		add(btnExitVideoReward);
	}


	private void startVideo() {
		String filename = "big_buck_bunny_1_minute.avi";
		video.playMedia(filename);
	}



}
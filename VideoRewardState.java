import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VideoRewardState extends GameStatePanel {

    private VideoPanel videoPanel;
    private JButton btnPausePlay;
    private ExitVideoRewardButton btnExitVideoReward;

    public VideoRewardState() {
        super.setupBackground("VIDEO REWARD");
        videoPanel = new VideoPanel();
        add(videoPanel);

        btnPausePlay = new JButton();
        btnPausePlay.setText("Pause");
        btnPausePlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnPausePlay.getText().equals("Pause")) {
                    videoPanel.pauseVideo();
                    btnPausePlay.setText("Play");
                } else {
                    videoPanel.playVideo();
                    btnPausePlay.setText("Pause");
                }
            }
        });

        btnExitVideoReward = new ExitVideoRewardButton();

        // fine to have more than one action listener on a button right?
        btnExitVideoReward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                videoPanel.stopVideo();
            }
        });


        add(btnPausePlay);
        add(btnExitVideoReward);

    }



}

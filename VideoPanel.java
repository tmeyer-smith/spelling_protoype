import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class VideoPanel extends JPanel {

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private final EmbeddedMediaPlayer video;

    public VideoPanel() {
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        video = mediaPlayerComponent.getMediaPlayer();
        add(mediaPlayerComponent, BorderLayout.CENTER);
       

    }

    public void startVideo() {
    	 String filename = "big_buck_bunny_1_minute.avi";
         video.playMedia(filename);
    }
    public void pauseVideo() {
        video.pause();
    }

    public void playVideo() {
        video.play();
    }

    public void stopVideo() {
        video.stop();
    }

}
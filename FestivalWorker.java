import javax.swing.SwingWorker;

public class FestivalWorker extends SwingWorker<Void, Void> {

    private String _message;

    public FestivalWorker(String message) {
        _message = message;
    }

    public Void doInBackground() {
        sayMessage();
        return null;
    }

    private void sayMessage() {
        ProcessBuilder pb = new ProcessBuilder("bash","-c","echo "+_message+" | festival --tts");
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
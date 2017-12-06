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
		// Makes a system call to the unix shell to use the program Festival to read out the message
        ProcessBuilder pb = new ProcessBuilder("festival","(voice_" + GameStateManager.getGSM().getVoice() + ")",
        		                               "(SayText \"" + _message + "\")" + "(quit)");
        try {
            Process p = pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
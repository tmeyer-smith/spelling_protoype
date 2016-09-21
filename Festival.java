import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Festival {
	
	
	public static void use(String message) {
        FestivalWorker worker = new FestivalWorker(message);
        worker.execute();

    }
	
//	public static void changeSpeed(int wordLength) {
//		String duration;
//		if (wordLength<4){
//			duration = "4";
//		}
//		else {
//			duration = "1";
//		}
//		
//		// add call to SayText within process builder and have (quit) at the end
//		// echo SayText and everything into festival with |
//        ProcessBuilder pb = new ProcessBuilder("festival","(Parameter.set 'Duration_Stretch " + duration + "')");
//        try {
//            Process p = pb.start();
//            p.waitFor();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
	
	public static String[] getVoices() {
		
		BufferedReader br = getVoicesReader();
		String[] voices = extractVoices(br);
		return voices;
		
	}

	private static BufferedReader getVoicesReader() {
		
		ProcessBuilder pb = new ProcessBuilder("bash","-c","echo \"(voice.list)\" | festival --interactive");
        try {
            Process p = pb.start();
            p.waitFor();
            return new BufferedReader(new InputStreamReader (p.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
		
	}
	
	private static String[] extractVoices(BufferedReader br) {
		String line = "";
		ArrayList<String> output = new ArrayList<String>();
		try {
			while ((line = br.readLine()) != null) {
				output.add(line);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		int firstVoice = output.indexOf("festival> (rab_diphone");
		
		// Removes unwanted lines at the start of output stream
		for (int i = 0; i<firstVoice; i++) {
			output.remove(0);
		}
		
		// Removes festival> at the start of first voice
		output.set(0, output.get(0).substring(11));
		
		// Finds index of last voice
		int lastVoice = output.indexOf("festival> ")-1;
		
		// Removes "festival> " as the last line in the output
		output.remove(lastVoice+1);
		
		// Removes space at start and ) at end of last voice
		output.set(lastVoice, output.get(lastVoice).substring(1, output.get(lastVoice).length()-1));
		
		
		// Removes unwanted lines at the start of output stream
		for (int i = 1; i<output.size()-1; i++) {
			output.set(i, output.get(i).substring(1));
		}
		
		String[] voices = new String[output.size()-1];
		
		// Convert ArrayList to String[]
		for (int i = 0; i<output.size()-1; i++) {
			voices[i] = output.get(i);
		}
		
		return voices;
	}

}
public class Festival {
	
	
	public static void use(String message) {
        FestivalWorker worker = new FestivalWorker(message);
        worker.execute();

    }
	
	public static void changeSpeed(int wordLength) {
		String duration;
		if (wordLength<4){
			duration = "4";
		}
		else {
			duration = "1";
		}
		
		// add call to SayText within process builder and have (quit) at the end
		// echo SayText and everything into festival with |
        ProcessBuilder pb = new ProcessBuilder("festival","(Parameter.set 'Duration_Stretch " + duration + "')");
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
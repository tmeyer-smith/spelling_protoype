public class GameStateManager {

    public enum State {
        menu,
        statistics,
        settings,
        play,
        pregame,
        postgame
    }

    private GameStatePanel _currentState;
	private static String _voice;
	private static String _level;
    private static GameStateManager _gsm;

    private GameStateManager() {
        _currentState = new MenuState();
        _voice = "voice 1";
        _level = "1";
    }
    

    public static void initializeGSM() {
    	if (_gsm==null) {
    		_gsm = new GameStateManager();
    		_gsm.startState(_gsm._currentState);
    	}
    }
    
    
    public static GameStateManager getGSM() {
        return _gsm;
    }



	public static void changeState(State state) {
        getGSM().changeCurrentState(state);
    }

    private void changeCurrentState(State state) {

        switch (state) {
        case menu :
        	_currentState = new MenuState();
        	break;
        case settings :
        	_currentState = new SettingsState();
        	break;
        case statistics :
        	_currentState = new StatsState();
        	break;
        case play:
        	_currentState = new PlayState();
        	break;
        case postgame:
        	_currentState = new PostGameState();
        	break;
        case pregame:
        	_currentState = new PreGameState();
        	break;
        default:
        	break;
        }

        startState(_currentState);
    }

    private void startState(GameStatePanel gs) {
        Game.addToFrame(gs);
    }


    
    public static String getVoice() {
		return _voice;
	}
    
	public static void changeVoice(String voice) {
	// CHANGING OF VOICE WITHIN SYSTEM NEEDS TO BE IMPLEMENTED	
	// festival (voice_rab_diphone)
		getGSM()._voice = voice;
	}

    
	public static String getLevel() {
		return _level;
	}


	public static void setLevel(String level) {
		getGSM()._level = level;
	}





}

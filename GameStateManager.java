public class GameStateManager {

    public enum State {
        menu,
        statistics,
        settings,
        play,
        pregame,
        postgame,
        videoReward,
        review
    }

    private GameStatePanel _currentState;
	private String _voice;
	private String _level;
    private static GameStateManager _gsm;

    private InGameStorage _storage;

    private GameStateManager() {
        _currentState = new MenuState(); 
        _voice = "rab_diphone";
        _level = "1";
    }
    

    public static void initializeGSM() {
    	if (_gsm==null) {
    		_gsm = new GameStateManager();
    		_gsm.startState(_gsm._currentState);
    	}
    }
    
    
    private static GameStateManager getGSM() {
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
            _storage = new InGameStorage(WordListsManager.getTestList(_level));
        	_currentState = new PlayState(_storage);
        	break;

            case review :
                _storage = new InGameStorage(WordListsManager.getReviewList(_level));
                _currentState = new PlayState(_storage);
                break;

//        case postgame:
//        	// do not use
//        	break;
        case pregame:
        	_currentState = new PreGameState();
        	break;
        case videoReward:
            _currentState = new VideoRewardState();
            break;
        default:
        	break;
        }

        startState(_currentState);
    }

    public static void goToPostGame(InGameStorage storage) {
        getGSM()._currentState = new PostGameState(storage);
        startState(getGSM()._currentState);
    }

    protected static void startState(GameStatePanel gs) {
        Game.addToFrame(gs);
    }


    
    public static String getVoice() {
		return getGSM()._voice;
	}
    
	public static void changeVoice(String voice) {
		getGSM()._voice = voice;
	}

    
	public static String getLevel() {
		return getGSM()._level;
	}


	public static void setLevel(String level) {
		getGSM()._level = level;
	}





}

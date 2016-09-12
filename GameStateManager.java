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
    private static GameStateManager _gsm;

    private GameStateManager() {
        _currentState = new MenuState();
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


}

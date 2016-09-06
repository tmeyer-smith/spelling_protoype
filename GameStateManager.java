

import java.util.ArrayList;

public class GameStateManager {

    public enum State {
        menu
        
    }

    private GameStatePanel _currentState;
    private static GameStateManager _gsm;
    private ArrayList<Integer> _states;

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
        _currentState.stopState();

        switch (state) {
            case menu :
                _currentState = new MenuState();
        }

        startState(_currentState);
    }

    private void startState(GameStatePanel gs) {
        Game.addToFrame(gs);
    }

}

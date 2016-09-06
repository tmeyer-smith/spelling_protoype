import java.util.ArrayList;

public class GameStateManager {

    public enum states {
        menu
    }

    private GameState _currentState;

    private static GameStateManager _gsm;
    private ArrayList<Integer> _states;

    private GameStateManager() {
        //_currentState = new MenuState();
    }

    private static GameStateManager getGSM() {
        if (_gsm==null) {
            _gsm = new GameStateManager();
        }
        return _gsm;
    }

    public static void changeState(states state) {
        getGSM().changeCurrentState(state);
    }

    private void changeCurrentState(states state) {
        _currentState.stopState();

        switch (state) {
            case menu :
                //_currentState = new MenuState();
        }

        startState(_currentState);
    }

    private void startState(GameState gs) {
        Game.addToFrame(gs);
    }

}

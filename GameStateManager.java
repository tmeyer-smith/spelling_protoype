
public class GameStateManager {

    public enum State {
        menu,statistics,settings,play,pregame,postgame
    }

    private GameStatePanel _currentState;
    private static GameStateManager _gsm;

    private GameStateManager() {
        //_currentState = new MenuState();
    }

    public static GameStateManager getGSM() {
        return _gsm;
    }

    public static void initialiseGSM() {
        if (_gsm==null) {
            _gsm = new GameStateManager();
            _gsm.startState(_gsm._currentState);
        }
    }

    public static void changeState(State state) {
        getGSM().changeCurrentState(state);
    }

    private void changeCurrentState(State state) {
        stopState();

        switch (state) {
            case menu :
                //_currentState = new MenuState();
                break;

        }

        startState(_currentState);
    }

    private void startState(GameStatePanel gs) {
        Game.addToFrame(gs);
    }
    private void stopState() {
        Game.clearFrame();
    }

    private GameStatePanel getPanel() {
        return _currentState;
    }

}

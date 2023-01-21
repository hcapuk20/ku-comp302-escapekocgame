package pause;

public class PauseObserver implements Observer {
    @Override
    public void update(boolean isPaused) {
        if (isPaused) {
            // Add logic to pause the game
        } else {
            // Add logic to resume the game
        }
    }
}


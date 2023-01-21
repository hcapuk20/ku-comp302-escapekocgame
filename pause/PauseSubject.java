package pause;

import java.util.ArrayList;
import java.util.List;

public class PauseSubject implements Subject {
    private boolean isPaused;
    private List<Observer> observers;

    public PauseSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(isPaused);
        }
    }

    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
        notifyObservers();
    }
}

package org.kodvabt.warehouse.manager.delivery;

public interface Observable {
    void notifyObservers();
    void attach(Observer observer);
    void detach(Observer observer);
}

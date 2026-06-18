package Design_Patterns_and_Principles.ObserverPatternExample;

import java.util.*;

public class StockMarket implements Stock {

    private List<Observer> observers =
            new ArrayList<>();

    private double stockPrice;

    public void register(
            Observer observer) {

        observers.add(observer);

    }

    public void deregister(
            Observer observer) {

        observers.remove(observer);

    }

    public void notifyObservers() {

        for(Observer observer
                : observers){

            observer.update(
                stockPrice
            );

        }

    }

    public void setPrice(
            double stockPrice){

        this.stockPrice =
                stockPrice;

        notifyObservers();

    }

}
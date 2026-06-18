package Design_Patterns_and_Principles.ObserverPatternExample;



public interface Stock {
   void register(Observer observer);

    void deregister(Observer observer);

    void notifyObservers();
}

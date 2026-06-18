package Design_Patterns_and_Principles.ObserverPatternExample;

public class MobileApp
implements Observer {

    public void update(
            double price){

        System.out.println(
            "Mobile Updated: "
            + price
        );

    }

}
package Design_Patterns_and_Principles.ObserverPatternExample;

public class WebApp
implements Observer {

    public void update(
            double price){

        System.out.println(
            "Web Updated: "
            + price
        );

    }

}
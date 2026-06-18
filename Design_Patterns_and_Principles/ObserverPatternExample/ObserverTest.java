package Design_Patterns_and_Principles.ObserverPatternExample;

public class ObserverTest {

    public static void main(
            String[] args){

        StockMarket market =
            new StockMarket();

        Observer mobile =
            new MobileApp();

        Observer web =
            new WebApp();

        market.register(
            mobile
        );

        market.register(
            web
        );

        market.setPrice(
            1250
        );

    }

}
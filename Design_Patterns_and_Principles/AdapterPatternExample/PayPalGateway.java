package Design_Patterns_and_Principles.AdapterPatternExample;

public class PayPalGateway {

  public void makePayment(double amount) {
    System.out.println("Processing payment of $" + amount + " through PayPal.");
  }
  
}

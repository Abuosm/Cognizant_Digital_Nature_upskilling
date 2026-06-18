package Design_Patterns_and_Principles.AdapterPatternExample;

public class StripeGateway {
  
  public void chargeAmount(double amount) {
    System.out.println("Processing payment of $" + amount + " through Stripe.");
  }
  
}

package Design_Patterns_and_Principles.AdapterPatternExample;

public class StripeAdapter implements PaymentProcessor {
  
  private StripeGateway stripeGateway;
  
  public StripeAdapter(StripeGateway stripeGateway) {
    this.stripeGateway = stripeGateway;
  }
  
  @Override
  public void processPayment(double amount) {
    stripeGateway.chargeAmount(amount);
  }
  
}

package Design_Patterns_and_Principles.AdapterPatternExample;

public class AdapterTest {

  public static void main(String[] args) {
    StripeGateway stripeGateway = new StripeGateway();
    PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
    stripeAdapter.processPayment(100.0);
    
    PayPalGateway payPalGateway = new PayPalGateway();
    PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
    payPalAdapter.processPayment(200.0);
  }
  
}

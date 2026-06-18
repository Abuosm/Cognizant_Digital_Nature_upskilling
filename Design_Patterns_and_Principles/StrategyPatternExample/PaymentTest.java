package Design_Patterns_and_Principles.StrategyPatternExample;

public class PaymentTest {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

       
        PaymentStrategy creditCard =
                new CreditCardPayment("1234567890123456");

        context.setPaymentStrategy(creditCard);
        context.executePayment(100.00);


        
        PaymentStrategy paypal =
                new PayPalPayment("user@example.com");

        context.setPaymentStrategy(paypal);
        context.executePayment(250.00);
    }
}
interface PaymentProcessor {
    void processPayment(double amount);
}
class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}
class StripeGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }
    public void processPayment(double amount) {
        stripeGateway.sendPayment(amount);
    }
}
public class AdapterPatternTest {
    public static void main(String[] args) {
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        payPalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
    }
}

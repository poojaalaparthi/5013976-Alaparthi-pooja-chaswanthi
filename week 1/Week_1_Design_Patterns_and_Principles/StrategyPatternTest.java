import java.util.Scanner;


interface PaymentStrategy {
    void pay(double amount);
}


class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
     
        System.out.println("Payment successful using Credit Card: " + cardNumber);
    }
}


class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
      
        System.out.println("Payment successful using PayPal account: " + email);
    }
}


class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}


public class StrategyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select payment method (1 for Credit Card, 2 for PayPal):");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        PaymentStrategy paymentStrategy = null;
        switch (choice) {
            case 1:
                System.out.println("Enter credit card number:");
                String cardNumber = scanner.nextLine();
                System.out.println("Enter card holder name:");
                String cardHolderName = scanner.nextLine();
                paymentStrategy = new CreditCardPayment(cardNumber, cardHolderName);
                break;
            case 2:
                System.out.println("Enter PayPal email:");
                String email = scanner.nextLine();
                paymentStrategy = new PayPalPayment(email);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        System.out.println("Enter amount to pay:");
        double amount = scanner.nextDouble();

       
        PaymentContext paymentContext = new PaymentContext(paymentStrategy);
        paymentContext.executePayment(amount);

        scanner.close();
    }
}

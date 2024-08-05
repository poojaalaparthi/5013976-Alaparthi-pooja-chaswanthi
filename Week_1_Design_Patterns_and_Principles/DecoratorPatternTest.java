import java.util.Scanner;


interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}


abstract class NotifierDecorator implements Notifier {
    protected Notifier decoratedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.decoratedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message);
    }
}


class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the original notifier
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}


class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);         sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}


public class DecoratorPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        Notifier emailNotifier = new EmailNotifier();

      
        System.out.println("Include SMS notification? (yes/no):");
        boolean includeSMS = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("Include Slack notification? (yes/no):");
        boolean includeSlack = scanner.nextLine().equalsIgnoreCase("yes");

       
        Notifier notifier = emailNotifier;
        if (includeSMS) {
            notifier = new SMSNotifierDecorator(notifier);
        }

        
        if (includeSlack) {
            notifier = new SlackNotifierDecorator(notifier);
        }


        System.out.println("Enter the message to send:");
        String message = scanner.nextLine();


        notifier.send(message);


        scanner.close();
    }
}

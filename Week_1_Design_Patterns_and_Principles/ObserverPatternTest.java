import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}


class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

interface Observer {
    void update(String stockName, double price);
}


class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App: Stock " + stockName + " has a new price: " + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Web App: Stock " + stockName + " has a new price: " + price);
    }
}


public class ObserverPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.println("Enter the stock name:");
        String stockName = scanner.nextLine();

        System.out.println("Enter the initial stock price:");
        double initialPrice = scanner.nextDouble();
        scanner.nextLine(); 
        StockMarket stockMarket = new StockMarket(stockName, initialPrice);

        List<Observer> observers = new ArrayList<>();
        boolean moreObservers = true;
        while (moreObservers) {
            System.out.println("Enter the type of observer to add (1 for MobileApp, 2 for WebApp), or 0 to stop:");
            int observerType = scanner.nextInt();
            scanner.nextLine(); 
            switch (observerType) {
                case 1:
                    observers.add(new MobileApp());
                    break;
                case 2:
                    observers.add(new WebApp());
                    break;
                case 0:
                    moreObservers = false;
                    break;
                default:
                    System.out.println("Invalid choice, please enter 1, 2, or 0.");
            }
        }

     
        for (Observer observer : observers) {
            stockMarket.registerObserver(observer);
        }

   
        System.out.println("Enter the new stock price:");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        stockMarket.setPrice(newPrice);

    
        if (!observers.isEmpty()) {
            System.out.println("Enter the type of observer to remove (1 for MobileApp, 2 for WebApp):");
            int observerTypeToRemove = scanner.nextInt();
            scanner.nextLine();

            Observer observerToRemove = null;
            for (Observer observer : observers) {
                if ((observerTypeToRemove == 1 && observer instanceof MobileApp) ||
                    (observerTypeToRemove == 2 && observer instanceof WebApp)) {
                    observerToRemove = observer;
                    break;
                }
            }

            if (observerToRemove != null) {
                stockMarket.deregisterObserver(observerToRemove);
                System.out.println("Observer removed.");
            } else {
                System.out.println("Observer not found.");
            }
        }

        System.out.println("Enter the new stock price:");
        newPrice = scanner.nextDouble();
        scanner.nextLine(); 
        stockMarket.setPrice(newPrice);
        scanner.close();
    }
}

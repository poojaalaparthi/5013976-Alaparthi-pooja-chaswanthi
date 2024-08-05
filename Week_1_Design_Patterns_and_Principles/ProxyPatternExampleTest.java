
import java.util.*;

 interface Image {
    void display();
}
 class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
       
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

 class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    private boolean isLoaded = false;
    public ProxyImage(String filename) {
        this.filename = filename;
    }
    @Override
    public void display() {
        if (!isLoaded) {
            realImage = new RealImage(filename);
            isLoaded = true;
        }
        realImage.display();
    }
}

public class ProxyPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.println("Enter the number of images to display:");
        int numImages = scanner.nextInt();
        scanner.nextLine(); 

        Image[] images = new Image[numImages];


        for (int i = 0; i < numImages; i++) {
            System.out.println("Enter filename for image " + (i + 1) + ":");
            String filename = scanner.nextLine();
            images[i] = new ProxyImage(filename);
        }

        for (int i = 0; i < numImages; i++) {
            System.out.println("Displaying image " + (i + 1) + ":");
            images[i].display();
        }

        scanner.close();
    }
}

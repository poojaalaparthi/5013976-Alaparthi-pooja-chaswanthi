import java.util.Scanner;

interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("The light is ON");
    }

    public void turnOff() {
        System.out.println("The light is OFF");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("Enter command (1 for Light ON, 2 for Light OFF, 0 to Exit):");
            int commandChoice = scanner.nextInt();

            switch (commandChoice) {
                case 1:
                    remote.setCommand(lightOn);
                    remote.pressButton();
                    break;
                case 2:
                    remote.setCommand(lightOff);
                    remote.pressButton();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 0.");
            }
        }
    }
}

import java.util.Scanner;

public class Computer {
    private String CPU;
    private int RAM;
    private int storage;
    private String GPU;
    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private String GPU;
        public Builder withCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder withRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }
        public Builder withStorage(int storage) {
            this.storage = storage;
            return this;
        }
        public Builder withGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
    }
    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM=" + RAM +
                ", storage=" + storage +
                ", GPU='" + GPU + '\'' +
                '}';
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CPU: ");
        String cpu = scanner.nextLine();
        System.out.print("Enter RAM: ");
        int ram = scanner.nextInt();
        System.out.print("Enter Storage: ");
        int storage = scanner.nextInt();
        System.out.print("Enter GPU (optional, press Enter if none): ");
        String gpu = scanner.next();
        Computer computer = new Computer.Builder()
                .withCPU(cpu)
                .withRAM(ram)
                .withStorage(storage)
                .withGPU(gpu.isEmpty() ? null : gpu)
                .build();
        System.out.println("\nComputer Configuration:");
        System.out.println(computer);
        scanner.close();
    }
}

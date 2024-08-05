import java.util.*;
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public String toString()
    {
        return "EmployeeId: "+employeeId+"\nEmployee name:"+name+"\nPosition: "+position+"\nSalary: "+salary;

    }
}
class EmployeeManagementSystem {
    private static Employee[] employees;
    private static int size=0;
    public static void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }
    public static Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }
    public static void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println("Details of Employee"+(i+1)+": \n"+employees[i]);
        }
    }
    public static void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the max size of the array");
        int n=sc.nextInt();
        employees=new Employee[n];
        int choice;
        do
        {
            System.out.println("1:ADD\n2.SEARCH\n3.TRAVERSE\n4.DELETE\n5:EXIT");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1: System.out.print("Enter EmployeeID: ");
                        int id=sc.nextInt();
                        System.out.print("Enter Employee Name: ");
                        String name=sc.next();
                        System.out.print("Enter Employee Position: ");
                        String p=sc.next();
                        System.out.print("Enter Employee Salary: ");
                        double s=sc.nextDouble();
                        addEmployee(new Employee(id, name, p, s));
                    break;
                case 2: System.out.println("Enter EmployeeID");
                        Employee temp=searchEmployee(sc.nextInt());
                        if(temp==null)
                            System.out.println("Employee not found");
                        else
                            System.out.println("Employee found\nDetains:\n"+temp);
                        break;
                case 3: traverseEmployees();
                        break;
                case 4: System.out.println("Enter EmployeeID");
                        deleteEmployee(sc.nextInt());
                        break;
                case 5: System.out.println("Thank you for using Employee Management System");
                        break;
                default:System.out.println("Invalid Choice\nPlease Try again");
                    break;
            }
        }while(choice!=5);
        sc.close();
    }
}

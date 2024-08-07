import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public String getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

public class MVCPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial student details:");

        System.out.print("Name: ");
        String initialName = scanner.nextLine();

        System.out.print("ID: ");
        String initialId = scanner.nextLine();

        System.out.print("Grade: ");
        String initialGrade = scanner.nextLine();

        Student student = new Student(initialName, initialId, initialGrade);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        System.out.println("\nInitial Student Details:");
        controller.updateView();

        System.out.println("\nEnter updated student details:");

        System.out.print("New Name: ");
        String newName = scanner.nextLine();

        System.out.print("New ID: ");
        String newId = scanner.nextLine();

        System.out.print("New Grade: ");
        String newGrade = scanner.nextLine();

        controller.setStudentName(newName);
        controller.setStudentId(newId);
        controller.setStudentGrade(newGrade);

        System.out.println("\nUpdated Student Details:");
        controller.updateView();

        scanner.close();
    }
}

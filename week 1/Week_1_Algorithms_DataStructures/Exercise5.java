import java.util.*;
class Task {
    int taskId;
    String taskName;
    String status;
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
    public String toString() {
        return "TaskID:" + taskId + "\nTask Name: " + taskName + "\nStatus: " + status;
    }
}
class TaskManagementSystem {
    private static LinkedList<Task> tasks=new LinkedList<>();
    public static void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added Sucessfully");
    }
    public static Task searchTask(int taskId) {
        for (Task task : tasks)
            if (task.taskId == taskId)
                return task;
        return null;
    }
    public static void traverseTasks() {
        for (Task task : tasks)
            System.out.println(task+"\n");
    }
    public static void deleteTask(int taskId) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.taskId== taskId) {
                iterator.remove();
                System.out.println("Task deleted successfully");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("1:ADD\n2.SEARCH\n3.TRAVERSE\n4.DELETE\n5:EXIT");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1: System.out.print("Enter TaskID: ");
                        int id=sc.nextInt();
                        System.out.print("Enter Task Name: ");
                        String name=sc.next();
                        System.out.print("Enter Task status: ");
                        String s=sc.next();
                        addTask(new Task(id, name, s));
                    break;
                case 2: System.out.println("Enter TaskID");
                        Task temp=searchTask(sc.nextInt());
                        if(temp==null)
                            System.out.println("Task not found");
                        else
                            System.out.println("Task found\nDetains:\n"+temp);
                        break;
                case 3: traverseTasks();
                        break;
                case 4: System.out.println("Enter TaskID");
                        deleteTask(sc.nextInt());
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

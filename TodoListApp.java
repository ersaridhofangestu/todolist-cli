import java.util.Scanner;

public class TodoListApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                displayMenu();
                int choice = getUserChoice(scanner);
                exit = handleUserChoice(choice, scanner, taskManager);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Todo List Menu ===");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Mark Task Status (In Progress / Done)");
        System.out.println("5. List All Tasks");
        System.out.println("6. List Done Tasks");
        System.out.println("7. List Not Done Tasks");
        System.out.println("8. List in Progress Tasks");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    private static boolean handleUserChoice(int choice, Scanner scanner, TaskManager taskManager) {
        scanner.nextLine();
        switch (choice) {
            case 1 -> addTask(scanner, taskManager);
            case 2 -> updateTask(scanner, taskManager);
            case 3 -> deleteTask(scanner, taskManager);
            case 4 -> updateTaskStatus(scanner, taskManager);
            case 5 -> taskManager.listAllTasks();
            case 6 -> taskManager.listDoneTask();
            case 7 -> taskManager.listNotDoneTask();
            case 8 -> taskManager.listInProgressTasks();
            case 9 -> {
                return true;
            }
            default -> System.out.println("Invalid option.");
        }
        return false; 
    }

    private static void addTask(Scanner scanner, TaskManager taskManager) {
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        taskManager.addTask(description);
    }

    private static void updateTask(Scanner scanner, TaskManager taskManager) {
        System.out.println("Enter task ID to Update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter New Description: ");
        String newDescription = scanner.nextLine();
        taskManager.updateTask(updateId, newDescription);
    }

    private static void deleteTask(Scanner scanner, TaskManager taskManager) {
        System.out.println("Enter task ID to Delete: ");
        int deleteId = scanner.nextInt();
        taskManager.deleteTask(deleteId);
    }

    private static void updateTaskStatus(Scanner scanner, TaskManager taskManager) {
        System.out.println("Enter Task ID to update status: ");
        int statusId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter New Status (In Progress / Done): ");
        String status = scanner.nextLine();
        taskManager.updateTaskStatus(statusId, status);
    }
}

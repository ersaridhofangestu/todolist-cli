import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int taskIdCounter = 1;

    public void addTask(String descripton){
        Task newTask = new Task(taskIdCounter++, descripton);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    public void updateTask(int id, String newDescription){
        for (Task task : tasks) {
            if(task.getId() == id){
                task.setDescription(newDescription);
                System.out.println("Task update: " + task);
                return;
            }
        }
        System.out.println("Task not found with ID: " + id);
    }
    
    public void deleteTask(int id){
        tasks.removeIf((task) -> task.getId() == id);
        System.out.println("Task with ID " + id + " deleted");
    }

    public void updateTaskStatus(int id, String status){
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(status);
                System.out.println("Task status updated: " + id);
            }
        }
        System.out.println("Task not found with ID: " + id);
    }

    public void listAllTasks(){
        System.out.println("All Tasks:");
        for (Task task: tasks) {
            System.out.println(task);
        }
    }

    public void listDoneTask(){
        System.out.println("Done Tasks:");
        for (Task taks : tasks) {
            if ("Done".equalsIgnoreCase(taks.getStatus())){
                System.out.println("taks");
            }
        }
    }
    
    public void listNotDoneTask(){
        System.out.println("Not Done Tasks:");
        for (Task task : tasks) {
            if("Not".equalsIgnoreCase(task.getStatus())) {
                System.out.println(task);
            }
        }
    }
    

    public void listInProgressTasks(){
        System.out.println("In Progress Taks:");
        for(Task task : tasks){
            if ("In Progress".equalsIgnoreCase(task.getStatus())) {
                System.out.println(task);        
            }
        }
        
    }
    
}
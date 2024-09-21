public class Task {
    private int id;
    private String description;
    private String status;

    public enum Status {
        NOT_DONE, IN_PROGRESS, DONE
    }

    public Task (int id, String description){
        if(id <= 0){
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
        if(description == null || description.isEmpty()){
            throw new IllegalArgumentException("Description cannot be null or empty."); 
        }
        
        this.id = id;
        this.description = description;
        this.status = Status.NOT_DONE.name();
    }

    public int getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description + " Status: " + status;
    }
    
    
}
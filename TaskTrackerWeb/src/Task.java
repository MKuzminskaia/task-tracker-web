public class Task {
    private String title;
    private byte priority;

    public void setTitle(String title){
        this.title = title;
    }

    public void setPriority(byte priority){
        this.priority = priority;
    }

    public String getTitle(){
        return this.title;
    }

    public byte getPriority(){
        return this.priority;
    }
}

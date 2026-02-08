public class Task {
    private String name;
    private byte priority;

    public void setName(String name){
        this.name = name;
    }

    public void setPriority(byte priority){
        this.priority = priority;
    }

    public String getName(){
        return this.name;
    }

    public byte getPriority(){
        return this.priority;
    }
}

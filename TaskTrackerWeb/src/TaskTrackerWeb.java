import java.util.ArrayList;
import java.util.Scanner;



public class TaskTrackerWeb {


    public static void main (String[] args){
        try (Scanner input = new Scanner(System.in)){
            ArrayList<Task> userTasks = new ArrayList<>();

            for (int i = 0; i < 3; i++)
            {
                Task userTask = new Task();
                System.out.println("\nEnter title of your task: ");

                if (input.hasNextLine()){
                    userTask.setTitle(input.nextLine());
                    input.nextLine();
                } else {
                    userTask.setTitle("New task without title");
                }

                System.out.println("\nEnter priority (1-3): ");

                if (input.hasNextByte()) {
                    userTask.setPriority(input.nextByte());
                    input.nextLine();
                } else {
                    userTask.setPriority((byte)1);
                }

                userTasks.add(userTask);
            }

            for (int i = 0; i<3; i++)
            {
                System.out.println("\nYou entered title of task: " + userTasks.get(i).getTitle());
                System.out.println("\nYou Entered priority of task: " + userTasks.get(i).getPriority());
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;



public class TaskTrackerWeb {


    public static void main (String[] args){
        String userMenuItem = "";
        try (Scanner menuItem = new Scanner(System.in)) {
            do {
                System.out.println("Select a menu item ( 1 | 2| 3 ): ");
                System.out.println("--------------------");
                System.out.println(" 1 | Add task   | ");
                System.out.println(" 2 | List tasks | ");
                System.out.println(" 3 | Exit       | ");

                if(menuItem.hasNextLine()){
                    userMenuItem = menuItem.nextLine().trim();
                    switch (userMenuItem) {
                        case "1":
                                ArrayList<Task> userTasks = new ArrayList<>();

                                for (int i = 0; i < 3; i++) {
                                    Task userTask = new Task();
                                    System.out.println("Enter title of your task: ");
                                    userTask.setTitle(menuItem.nextLine().trim());

                                    System.out.println("Enter priority (1-3): ");

                                    String prior = menuItem.nextLine().trim();
                                    try {
                                        userTask.setPriority(Byte.parseByte(prior));
                                    }
                                    catch (NumberFormatException e){
                                        userTask.setPriority((byte) 1);
                                    };

                                    userTasks.add(userTask);
                                }

                                for (int i = 0; i < 3; i++) {
                                    System.out.println("You entered title of task: " + userTasks.get(i).getTitle());
                                    System.out.println("You Entered priority of task: " + userTasks.get(i).getPriority());
                                }

                            break;
                        case "2":
                            System.out.println("You have not tasks now");
                            break;
                        case "3":
                            System.out.println("Exit");
                            break;
                        default:
                            System.out.println("Repeat your choose");
                    }
                } else {
                    System.out.println("Your select is not correct");
                }
            } while (!userMenuItem.trim().equals("3"));
        }
    }
}

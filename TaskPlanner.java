import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<String> task = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            task.add(input[i]);
        }

        int completedCount = 0;
        int droppedCount = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] temp = command.split("\\s+");
            String firstCommand = temp[0];

            if (firstCommand.equals("Complete")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < task.size()) {
                    task.set(Integer.parseInt(temp[1]), "0");
                }
            }

            if (firstCommand.equals("Change")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < task.size()) {

                    task.set(Integer.parseInt(temp[1]), temp[2]);

                }
            }

            if (firstCommand.equals("Drop")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < task.size()) {
                    task.set(Integer.parseInt(temp[1]), "-1");
                }
            }

            if (firstCommand.equals("Count")) {
                droppedCount = 0;
                if (temp[1].equals("Dropped")) {
                    for (String s : task) {
                        if (s.equals("-1")) {
                            droppedCount++;
                        }
                    }
                    System.out.println(droppedCount);
                } else if (temp[1].equals("Completed")) {
                    completedCount = 0;
                    for (String s : task) {
                        if (s.equals("0")) {
                            completedCount++;
                        }
                    }
                    System.out.println(completedCount);
                }
            }

            command = scanner.nextLine();
        }


        if (!task.isEmpty()) {
            for (String s : task) {
                if (!s.equals("-1") && !s.equals("0")) {
                    System.out.print(s + " ");
                }

            }
        }

    }
}

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> list;    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        String command;
        list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            command = sc.nextLine();
            runCommand(command);
        }
    }

    public static void runCommand(String command) {
        if(command.equals("size")) {
            System.out.println(list.size());
        } 
        else if (command.equals("pop_back")) {
            list.remove(list.size()-1);
        } 
        else {
            String[] commands = command.split(" ");
            int x = Integer.parseInt(commands[1]);

            if(commands[0].equals("get")) {
                System.out.println(list.get(x-1));
            }
            else if(commands[0].equals("push_back")) {
                list.add(x);
            }
        }
    }

}
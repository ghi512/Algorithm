import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            String s = sc.next();
            if(s.contains("push")) {
                int num = sc.nextInt();
                stack.push(num);
            }
            else if(s.contains("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            }
            else if(s.contains("size")) {
                System.out.println(stack.size());
            }
            else if(s.contains("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
            else if(s.contains("top")) {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
        }
    }
}

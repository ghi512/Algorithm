import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<k; i++) {
            int n = sc.nextInt();
            if(n == 0) {
                stk.pop();
            }
            else {
                stk.push(n);
            }
        }

        int sum = 0;
        int len = stk.size();
        for(int i=0; i<len; i++) {
            sum += stk.pop();
        }

        System.out.println(sum);
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int J = sc.nextInt();
        int start = 1;
        int end = M;
        int result = 0;
        
        for (int i = 0; i < J; i++) {
            int apple = sc.nextInt();
            if (start > apple) {
                result += start - apple;
                end -= start - apple;
                start = apple;
            } else if (end < apple) {
                result += apple - end;
                start += apple - end;
                end = apple;
            }
        }  
        System.out.print(result);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = 1000 - sc.nextInt();
        int answer = 0;

        int[] money = {500, 100, 50, 10, 5, 1};

        for(int m : money) {
            if (input <= 0) break;
            if(input / m > 0) {
                answer += (input / m);
                input %= m;
            }
        }

        System.out.println(answer);
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(getLCM(a,b));
        }
    }

    static int getLCM(int a, int b) {
        int gcd = 1;
        int lcm = 0;
        int max = Math.max(a,b);
        int min = Math.min(a,b);

        // 1. 유클리드 호제법으로 a,b의 최대공약수 gcd 구하기
        while(true) {
            if(max%min == 0) {
                gcd = min;
                break;
            }
            int temp = max % min;
            max = min;
            min = temp;
        }

        // 2. 최소공배수
        lcm = (a/gcd) * (b/gcd) * gcd;
        return lcm;
    }
}
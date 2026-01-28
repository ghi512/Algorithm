import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();

        boolean[] check = new boolean[(int)(Max - Min + 1)];
        for(long i=2; i*i <= Max; i++) {
            long pow = i*i; // 제곱수
            long startIdx = Min / pow;
            if(Min % pow != 0) {
                startIdx++;
            }

            for(long j=startIdx; pow*j <= Max; j++) {
                check[(int)((j*pow) - Min)] = true;
            }
        }

        int cnt = 0;
        for(int i=0; i<=Max-Min; i++) {
            if(!check[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();

        // 2 ~ 10^7(Min의 최대범위인 10^14의 제곱근) 사이의 소수를 구한다
        long[] A = new long[10000001];
        for(int i=2; i<A.length; i++) {
            A[i] = i;
        }

        for(int i=2; i<=Math.sqrt(A.length); i++) {
            if(A[i] == 0)  {
                continue;
            }
            for(int j=i*2; j<A.length; j += i) { // 배수 지우기
                A[j] = 0;
            }
        }

        int cnt = 0;
        for(int i=2; i<10000001; i++) {
            if(A[i] > 0) {
                long temp = A[i];

                while((double)A[i] <= (double)Max/(double)temp) {
                    if((double)A[i] >= (double)Min/(double)temp) {
                        cnt++;
                    }
                    temp *= A[i];
                }
            }
        }

        System.out.println(cnt);
    }
}
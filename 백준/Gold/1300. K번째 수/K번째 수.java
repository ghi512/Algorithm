import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        long start = 1, end = K;
        long answer = 0;

        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            // N개의 행을 돌면서 mid보다 작은 수의 개수 세기
            for(int i=1; i<=N; i++) {
                cnt += Math.min(mid/i, N);
            }

            if(cnt < K) {
                start = mid + 1;
            }
            else {
                answer = mid;
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
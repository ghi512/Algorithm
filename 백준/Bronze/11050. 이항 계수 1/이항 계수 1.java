import java.util.*;

public class Main {
    static int N, K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N+1][N+1];

        for(int i=0; i<=N; i++) {
            D[i][1] = 1; // i개 중 1개를 선택할 경우는 i개
            D[i][0] = 1; // i개 중 0개를 선택할 경우는 1개
            D[i][i] = 1; // i개 중 i개를 선택할 경우는 1개
        }

        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        System.out.println(D[N][K]);
    }
}
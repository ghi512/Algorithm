import java.util.*;

public class Main {
    static int N, M, T;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        D = new int[30][30];
        for(int i=1; i<30; i++) {
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for(int i=2; i<30; i++) {
            for(int j=1; j<=i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        for(int t=0; t<T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            System.out.println(D[M][N]);
        }
    }
}
import java.util.*;

public class Main {
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        D = new int[16][16];
        for(int i=1; i<=15; i++) {
            D[0][i] = i;
            D[i][1] = 1;
        }

        for(int i=1; i<=15; i++) {
            for(int j=2; j<=15; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j];
            }
        }

        for(int t=0; t<T; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(D[n][k]);
        }

    }
}
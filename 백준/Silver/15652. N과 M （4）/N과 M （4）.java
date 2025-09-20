import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        dfs(0, 1);
    }

    public static void dfs(int depth, int start) {

        if(depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<=N; i++) {
            arr[depth] = i;
            dfs(depth+1, i);
        }
    }
}


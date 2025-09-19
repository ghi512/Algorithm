import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        arr = new int[M];

        dfs(0);
    }

    static void dfs(int depth) {
        // depth는 현재 수열에서 몇 번째 자리를 채우고 있는지를 의미함
        if (depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;  // 숫자 i 사용함
                arr[depth] = i;     // 현재 자리에 i 넣기
                dfs(depth+1); // 다음 자리 채우러 가기
                visited[i] = false; // 다시 안 쓴 걸로 돌려놓기
            }
        }
    }
}


import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int[] nums;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        visited = new boolean[N];
        arr = new int[M];

        for(int i=0; i<N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        dfs(0);
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                arr[depth] = nums[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

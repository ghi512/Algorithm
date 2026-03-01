import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new  ArrayList<>();
        }
        visited = new boolean[N+1];

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        answer = new int[N+1];
        DFS(1);

        for(int i=2; i<=N; i++) {
            System.out.println(answer[i]);
        }
    }

    static void DFS(int n) {
        visited[n] = true;
        for(int next : tree[n]) {
            if(!visited[next]) {
                answer[next] = n;
                DFS(next);
            }
        }
    }
}
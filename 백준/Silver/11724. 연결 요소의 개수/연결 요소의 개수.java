import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }

    static void DFS(int node) {
        if(visited[node]) {
            return;
        }

        visited[node] = true;
        for(int i : list[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
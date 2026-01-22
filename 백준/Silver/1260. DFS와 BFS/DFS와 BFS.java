import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M, V; // 정점, 간선, 탐색시작노드

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
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

        for(int i=1; i<=N; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N+1];
        DFS(V);
        System.out.println();
        visited = new boolean[N+1];
        BFS(V);
    }

    static void DFS(int node) {
        if(visited[node]) {
            return;
        }

        visited[node] = true;
        System.out.print(node + " ");

        for(int i : list[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<Integer>();
        visited[node] = true;
        q.offer(node);

        while(!q.isEmpty()) {
            int now =  q.poll();
            System.out.print(now + " ");

            for(int i : list[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }

        }

    }
}
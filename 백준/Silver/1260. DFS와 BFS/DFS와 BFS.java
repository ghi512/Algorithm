import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=n; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[n+1];
        DFS(v);
        System.out.println();
        visited = new boolean[n+1];
        BFS(v);
    }

    public static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;

        for(int i : list[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for(int i : list[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

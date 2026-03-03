import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 초기화
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 노드 입력
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        // bfs
        depth = new int[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);

        // 질의
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a,b));
        }
    }

    static int LCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 두 노드 depth 맞추기
        while(depth[a] != depth[b]) {
            a = parent[a];
        }

        // 공통조상 나올때까지 한칸씩 올리기
        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    static void BFS(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root] = true;
        depth[root] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : tree[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[now] + 1;
                    parent[next] = now;
                    q.add(next);
                }
            }
        }
    }
}
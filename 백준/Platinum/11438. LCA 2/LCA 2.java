import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[][] parent;
    static int[] depth;
    static int kMax = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 초기화
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 입력
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        // bfs용 변수 초기화
        depth = new int[N+1];
        visited = new boolean[N+1];
        int temp = 1;
        while(temp <= N) {
            temp *= 2;
            kMax++;
        }

        // parent
        parent = new int[kMax+1][N+1];
        BFS(1);
        for(int k=1; k<=kMax; k++) {
            for(int n=1; n<=N; n++) {
                parent[k][n] = parent[k-1][parent[k-1][n]];
            }
        }

        // 질의
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a,b));
        }
    }

    static int LCA(int a, int b ) {
       if(depth[a] > depth[b]) {
           int temp = a;
           a = b;
           b = temp;
       }

       // depth 맞추기
       for(int k=kMax; k>=0; k--) {
           if(Math.pow(2,k) <= depth[b] - depth[a]) {
               if(depth[a] <= depth[parent[k][b]]) {
                   b = parent[k][b];
               }
           }
       }

       // 조상 찾기
       for(int k=kMax; k>=0; k--) {
           if(parent[k][a] != parent[k][b]) {
               a = parent[k][a];
               b = parent[k][b];
           }
       }

       return a!=b ? parent[0][a] : a;
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
                    q.add(next);
                    visited[next] = true;
                    parent[0][next] = now; // 부모 노드 저장
                    depth[next] = depth[now] + 1;
                }
            }
        }
    }
}
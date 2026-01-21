import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            tree[i] = new ArrayList<Edge>();
        }

        // 인접리스트 저장
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 정점번호

            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());
                tree[s].add(new Edge(e,v));
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(1);
        int max = 1;
        for(int i=2; i<=n; i++) {
            if(distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(Edge i : tree[now]) {
                int e = i.e;
                int value = i.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + value;
                }
            }
        }
    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}

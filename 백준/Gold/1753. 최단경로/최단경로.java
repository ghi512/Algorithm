import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K;
    static ArrayList<Edge>[] list;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[V+1];
        distance = new int[V+1];
        for(int i=1; i<=V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,w));
        }

        q.add(new Edge(K,0));
        distance[K] = 0;
        while(!q.isEmpty()) {
            Edge now = q.poll();
            int nowNode = now.node;
            if(visited[nowNode]) {
                continue;
            }
            visited[nowNode] = true;
            for(Edge next : list[nowNode]) {
                int nextNode = next.node;
                int nextValue = next.value;
                if(distance[nextNode] > distance[nowNode] + nextValue) {
                    distance[nextNode] = distance[nowNode] + nextValue;
                    q.add(new Edge(nextNode, distance[nextNode]));
                }
            }
        }

        for(int i=1; i<=V; i++) {
            if(visited[i]) {
                System.out.println(distance[i]);
            }
            else {
                System.out.println("INF");
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int value;
        Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }

        public int compareTo(Edge e) {
            if(this.value > e.value) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, S, E;
    static ArrayList<Edge>[] list;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        distance = new int[N+1];
        for(int i=1; i<=N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,v));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 전체 최단경로 구하기
        distance[S] = 0;
        q.add(new Edge(S,0));
        while(!q.isEmpty()) {
            Edge now = q.poll();
            int nowVertex = now.vertex;
            if(visited[nowVertex]) {
                continue;
            }
            visited[nowVertex] = true;
            for(Edge next : list[nowVertex]) {
                int nextVertex = next.vertex;
                int nextValue = next.value;
                if(!visited[nextVertex] && distance[nowVertex] + nextValue < distance[nextVertex]) {
                    distance[nextVertex] = distance[nowVertex] + nextValue;
                    q.add(new Edge(nextVertex, distance[nextVertex]));
                }
            }
        }

        // S -> E 최단경로
        System.out.println(distance[E]);
    }

    public static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
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
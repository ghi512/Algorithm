import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, K;
    public static ArrayList<Edge>[] list;
    public static PriorityQueue<Integer>[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        distance = new PriorityQueue[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
            distance[i] = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,v));
        }

        // 다익스트라
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,0)); // 출발지점
        distance[1].add(0);

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            for(Edge next : list[now.vertex]) {
                int newValue = now.value + next.value;

                // k개 미만이면 그냥 넣기
                if(distance[next.vertex].size() < K) {
                    distance[next.vertex].add(newValue);
                    pq.add(new Edge(next.vertex, newValue));
                }
                // k개인데 더 작으면 교체
                else if(distance[next.vertex].peek() > newValue){
                    distance[next.vertex].poll(); // 가장 큰 값 제거
                    distance[next.vertex].add(newValue);
                    pq.add(new Edge(next.vertex, newValue));
                }
            }
        }

        // 정답 출력
        for(int i=1; i<=N; i++) {
            if(distance[i].size() == K) {
                System.out.println(distance[i].peek());
            }
            else {
                System.out.println("-1");
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        int vertex;
        int value;
        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        public int compareTo(Edge e) {
            return this.value > e.value ? 1 : -1;
        }
    }
}
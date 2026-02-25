import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, S, E;
    public static Edge[] edges;
    public static long[] distance, cityMoney;
    public static boolean[] infinite;
    public static boolean isGee = false;
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 변수 초기화
        edges = new Edge[M];
        distance = new long[N];
        cityMoney = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE); // 최대금액을 구하야하므로 min

        // 엣지 리스트 입력받기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a,b,c);
        }

        // 도시에서 벌 수 있는 금액
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        // 벨만포드 (변형)
        distance[S] = cityMoney[S];
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;

                // 출발노드가 방문하지 않은 노드면 스킵
                if(distance[start] == Long.MIN_VALUE) {
                    continue;
                }
                // 금액이 크면 업데이트
                if(distance[end] < distance[start] + cityMoney[end] - price) {
                    distance[end] = distance[start] + cityMoney[end] - price;
                }
            }
        }

        // 무한 증가 판별
        infinite = new boolean[N];
        for(int i=0; i<M; i++) {
            int start = edges[i].start;
            int end = edges[i].end;
            int price = edges[i].price;

            if(distance[start] == Long.MIN_VALUE) {
                continue;
            }
            if(distance[end] < distance[start] + cityMoney[end] - price) {
                infinite[end] = true;
            }
        }

        // 사이클 내 노드에서 E까지 도달가능하면 Gee
        visited = new boolean[N];
        list = new ArrayList[N];
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            list[edges[i].start].add(edges[i].end);
        }
        bfs();

        // 출력
        if(distance[E] == Long.MIN_VALUE) {
            System.out.println("gg");
        }
        else if(isGee) {
            System.out.println("Gee");
        }
        else {
            System.out.println(distance[E]);
        }

    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            if(infinite[i]) {
                q.offer(i);
                visited[i] = true;
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == E) {
                isGee = true;
                break;
            }
            for(int next : list[now]) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }

    }

    public static class Edge {
        int start, end, price;
        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }
}
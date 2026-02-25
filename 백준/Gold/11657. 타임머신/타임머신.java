import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static boolean hasCycle = false;
    public static Edge[] edges;
    public static long[] distance;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 변수 초기화
        edges = new Edge[M+1];
        distance = new long[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 정보 담기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        // 최단거리 구하기 - 벨만포드
        distance[1] = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M; j++) {
                Edge edge = edges[j];
                // 더 작은 최단거리가 있으면 업데이트
                if(distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        // 음수사이클 있는지 확인
        for(int i=0; i<M; i++) {
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time) {
                hasCycle = true;
            }
        }

        // 결과 출력
        if(hasCycle) {
            System.out.println("-1");
        }
        else {
            for(int i=2; i<=N; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    public static class Edge {
        int start, end, time;
        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
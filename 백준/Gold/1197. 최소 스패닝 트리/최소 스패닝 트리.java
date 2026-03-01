import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static PriorityQueue<Edge> pq;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // edges 정보 입력받기 (pq에 넣기)
        pq = new PriorityQueue<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a,b,c));
        }

        // 부모 노드 정보 저장
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        // MST
        int useEdge = 0;
        int answer = 0;
        while(useEdge < N-1) {
            Edge now = pq.poll();
            if(find(now.s) != find(now.e)) {
                union(now.s, now.e);
                answer += now.v;
                useEdge++;
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int s, e, v;

        public Edge (int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        // 가중치 기준으로 오름차 정렬
        public int compareTo(Edge edge) {
            return this.v - edge.v;
        }
    }

    static int find(int n) {
        if(n == parent[n]) {
            return n;
        }
        else {
            return parent[n] = find(parent[n]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int sum = 0;

        // 랜선길이 pq에 넣기
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=N; j++) {
                char c = s.charAt(j-1);
                int len = 0;
                if(c >= 'a' && c <= 'z') {
                    len = c - 'a' + 1;
                }
                else if(c >= 'A' && c <= 'Z') {
                    len = c - 'A' + 27;
                }

                if(i != j && c != '0') {
                    pq.add(new Edge(i, j, len));
                }

                sum += len;
            }
        }

        // parent
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        // MST
        int useEdge = 0;
        int answer = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if(find(now.s) != find(now.e)) {
                union(now.s, now.e);
                useEdge++;
                answer += now.w;
            }
        }

        if(useEdge == N-1) {
            System.out.println(sum - answer);
        }
        else {
            System.out.println("-1");
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int n) {
        if(parent[n] == n) {
            return n;
        }
        else {
            return parent[n] = find(parent[n]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
}
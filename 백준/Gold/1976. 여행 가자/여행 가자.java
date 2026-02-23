import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parent;
    static int[][] city;
    static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        city = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        route = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(city[i][j] == 1) {
                    union(i,j);
                }
            }
        }

        int index = find(route[0]);
        for(int i=1; i<route.length; i++) {
            if(index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
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
}
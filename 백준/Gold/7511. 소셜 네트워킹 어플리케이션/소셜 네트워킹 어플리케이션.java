import java.util.*;
import java.io.*;

public class Main {

    static int N, K, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int t=1; t<=TC; t++) {

            N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }

            K = Integer.parseInt(br.readLine());
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }

            M = Integer.parseInt(br.readLine());
            System.out.println("Scenario " + t + ":");
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(find(a) == find(b)) {
                    System.out.println("1");
                }
                else {
                    System.out.println("0");
                }
            }
            System.out.println();
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
        if(n == parent[n]) {
            return n;
        }
        else {
            return parent[n] = find(parent[n]);
        }
    }
}
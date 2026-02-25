import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] distance;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) {
                    distance[i][j] = 0;
                }
                else {
                    distance[i][j] = INF;
                }
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(distance[a][b] > c) {
                distance[a][b] = c;
            }
        }

        // 플로이드워셜
        for(int k=1; k<=N; k++) {
            for(int s=1; s<=N; s++) {
                for(int e=1; e<=N; e++) {
                    if(distance[s][e] > distance[s][k] + distance[k][e]) {
                        distance[s][e] = distance[s][k] + distance[k][e];
                    }
                }
            }
        }

        //출력
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(distance[i][j] == INF) {
                    System.out.print("0 ");
                }
                else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
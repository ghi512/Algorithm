import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] distance;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) distance[i][j] = 0;
                else distance[i][j] = INF;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int s=1; s<=N; s++) {
                for(int e=1; e<=N; e++) {
                    if(distance[s][e] > distance[s][k] + distance[k][e]) {
                        distance[s][e] = distance[s][k] + distance[k][e];
                    }
                }
            }
        }

        int kebin = Integer.MAX_VALUE;
        int answer = 0;

        for(int i=1; i<=N; i++) {
            int temp = 0;
            for(int j=1; j<=N; j++) {
                temp += distance[i][j];
            }

            if(temp < kebin) {
                kebin = temp;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
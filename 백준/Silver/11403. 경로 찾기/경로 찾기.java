import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] distance;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        distance = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드워셜
        for(int k=0; k<N; k++) {
            for(int s=0; s<N; s++) {
                for(int e=0; e<N; e++) {
                    if(distance[s][k] == 1 && distance[k][e] == 1) {
                        distance[s][e] = 1;
                    }
                }
            }
        }

        // 출력
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
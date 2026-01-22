import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = { 0, 1, 0, -1};
    static int[] dy = { 1, 0, -1, 0};
    static int[][] graph;
    static boolean[][] visited;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        BFS(0,0);
        System.out.println(graph[N-1][M-1]);
    }

    static void BFS(int i,int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int now[] = q.poll();
            for(int k=0; k<4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x>=0 && y>=0 && x<N && y<M) {
                    if(graph[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        graph[x][y] = graph[now[0]][now[1]] + 1;
                        q.add(new int[] {x,y});
                    }
                }
            }
        }

    }

}

import java.util.*;

class Solution {
    // 상, 하, 좌, 우
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    
    private static int[][] maps;
    private static int N, M;
    private static boolean[][] visited;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        N = maps.length;
        M = maps[0].length;
        
        // 내 위치 (0,0), 상대편 위치 (n-1, m-1)
        visited = new boolean[N][M];
        bfs();

        if(maps[N-1][M-1] == 1) {
            return -1;
        }
        return maps[N-1][M-1];
        
    }
    
    public void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
                        
            for(int d=0; d<4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M) {
                    continue;
                }
                
                if(!visited[nx][ny] && maps[nx][ny] == 1) {
                    q.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[now[0]][now[1]] + 1;
                }
            }
        }
    }
}
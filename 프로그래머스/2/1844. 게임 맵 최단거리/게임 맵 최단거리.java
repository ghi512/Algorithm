import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if(x == n-1 && y == m-1) {
                return dist;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m) {
                    continue;
                }
                
                if(maps[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny, dist+1});
            }
        }
        
        return -1;
    }
}
import java.util.*;

class Solution {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static int width, height;
    static char[][] map;
    static boolean[][] visited;
    static Set<Integer> set;
    
    public int solution(String[] board) {
        width = board[0].length();
        height = board.length;
        map = new char[height][width];
        visited = new boolean[height][width];
        set = new HashSet<>();
        
        int startR = -1;
        int startC = -1;
        
        for(int h=0; h<height; h++) {
            for(int w=0; w<width; w++) {
                map[h][w] = board[h].charAt(w);
                if(map[h][w] == 'R') {
                    startR = h; startC = w;
                }
            }
        }
        
        
        
        int answer = bfs(startR, startC);
        return answer;
    }
    
    public int bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startR, startC, 0});
        visited[startR][startC] = true;
        
        int answer = -1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];
            int cnt = cur[2];
            
            for(int d=0; d<4; d++) {
                int nr = cur_r;
                int nc = cur_c;
                
                // 다음 칸을 확인(범위,장애물)하고 가능하면 계속 미끄러지기
                while(checkArea(nr + dr[d], nc + dc[d])
                     && map[nr + dr[d]][nc + dc[d]] != 'D')
                {
                    nr = nr + dr[d];
                    nc = nc + dc[d];
                }
                
                // 최종 도달 위치
                if(map[nr][nc] == 'G') {
                    return cnt+1;
                }
                
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, cnt+1});
                }
            }
        }
        
        return -1;
    }
    
    public boolean checkArea(int r, int c) {
        if(r<0 || r>=height || c<0 || c>=width) {
            return false;
        }
        return true;
    }
}
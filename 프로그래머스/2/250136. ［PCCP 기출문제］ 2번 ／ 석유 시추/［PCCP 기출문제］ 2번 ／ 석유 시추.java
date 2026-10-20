/**
* land[r][c]
* 가로: r (0 ~ m-1)
* 세로: c (0 ~ n-1)
**/

import java.util.*;

class Solution {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static int n,m;
    static boolean[][] visited;
    static int[][] map;
    static int[] oilTotal;
    static Set<Integer> cols;
    
    public int solution(int[][] land) {
        n = land.length; // 행r 개수 (세로)
        m = land[0].length; // 열c 개수 (가로)
        map = land;
        
        visited = new boolean[n][m];
        oilTotal = new int[m];
        
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(land[r][c] == 1 && !visited[r][c]) {
                    cols = new HashSet<>();
                    int size = bfs(r,c);
                    
                    for(int col : cols) {
                        oilTotal[col] += size;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int oil : oilTotal) {
            answer = Math.max(oil, answer);
        }
        return answer;
    }
    
    public int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r,c});
        visited[r][c] = true;
        
        int size = 0;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cr = current[0];
            int cc = current[1];
            
            size++;
            cols.add(cc);
            
            for(int d=0; d<4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(checkArea(nr, nc)
                  && !visited[nr][nc]
                  && map[nr][nc] == 1)
                {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
        
        return size;
    }
    
    public boolean checkArea(int r, int c) {
        if(r<0 || r>=n || c<0 || c>=m) {
            return false;
        }
        return true;
    }
}
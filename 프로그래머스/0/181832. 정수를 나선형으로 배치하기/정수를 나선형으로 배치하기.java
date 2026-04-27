class Solution {
    public int[][] solution(int n) {
        int[][] board = new int[n][n];
        
        // (0,0) (0,1) (0,2)
        // (1,0) (1,1) (1,2)
        
        // 우, 하, 좌, 상
        // (dx, dy)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int x = 0, y = 0;
        int dir = 0;
        
        for(int i=1; i <= n*n; i++) {
            board[x][y] = i;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx<0 || ny<0 || nx>=n || ny>=n || board[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
        
        return board;
    }
}
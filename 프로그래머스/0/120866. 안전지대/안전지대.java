class Solution {
    static int len = 0;
    static int[][] map;
    
    public int solution(int[][] board) {
        len = board[0].length;
        map = board;
        
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(map[i][j] == 1) {
                    checkAroundBomb(i, j);
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(map[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void checkAroundBomb(int x, int y) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx<0 || ny<0 || nx>=len || ny>=len) {
                continue;
            }
            
            if(map[nx][ny] != 1) {
                map[nx][ny] = 2;
            }
        }
    }
}
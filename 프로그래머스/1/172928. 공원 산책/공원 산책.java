class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 동 E, 서 W, 남 S, 북 N
        String dirs = "EWSN";
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        int[][] map = new int[park.length][park[0].length()];
        int[] now = {0, 0};
        
        for(int i=0; i<map.length; i++) {
            String[] temp = park[i].split("");
            for(int j=0; j<map[i].length; j++) {
                if(temp[j].equals("S")) {
                    now[0] = i; now[1] = j;
                    map[i][j] = 1;
                }
                else if(temp[j].equals("X")) {
                    map[i][j] = -1;
                }
            }
        }
        
        for(String r : routes) {
            String[] s = r.split(" ");
            int idx = dirs.indexOf(s[0]);
            int n = Integer.valueOf(s[1]);
            
            int nx = now[0] + (n * dx[idx]);
            int ny = now[1] + (n * dy[idx]);
            
            // 1. 범위를 벗어나는 경우
            if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length) {
                continue;
            }
            // 2. 장애물 체크
            boolean blocked = false;
            for(int k=1; k<=n; k++) {
                int cx = now[0] + (k * dx[idx]);
                int cy = now[1] + (k * dy[idx]); 
                if(map[cx][cy] < 0) {
                    blocked = true;
                    break;
                }
            }
            if(blocked) continue;
            
            now[0] = nx;
            now[1] = ny;
        }
        
        return now;
    }
}
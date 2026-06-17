class Solution {
    static int[][] d;
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        visited = new boolean[dungeons.length];
        dfs(k, 0);
        return answer;
    }
    
    public void dfs(int leftBlood, int cnt) {
        answer = Math.max(answer, cnt);
        
        for(int i=0; i<d.length; i++) {
            if(!visited[i] && leftBlood >= d[i][0]) {
                visited[i] = true;
                dfs(leftBlood - d[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}
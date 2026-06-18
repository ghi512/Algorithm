import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // check 전선을 끊고 개수 확인
        for(int[] check : wires) {
            graph = new ArrayList[n+1];
            for(int i=0; i<=n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            // check 빼고 그래프 만들기
            for(int[] wire : wires) {
                if(wire == check) continue;
                
                int a = wire[0];
                int b = wire[1];
                
                graph[a].add(b);
                graph[b].add(a);
            }
            
            visited = new boolean[n+1];
            
            int cnt = dfs(1); // 1번 송전탑이 속한 그룹의 크기
            int other = n - cnt; // 나머지 크기
            
            int diff = Math.abs(cnt - other);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    public int dfs(int n) {
        visited[n] = true;
        int cnt = 1;
        
        for(int next : graph[n]) {
            if(!visited[next]) {
                cnt += dfs(next);
            }
        }
        
        return cnt;
    }
}
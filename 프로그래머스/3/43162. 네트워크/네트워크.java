import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int n) {
        visited[n] = true;
        
        for(int next : graph[n]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
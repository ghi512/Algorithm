import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    graph[i+1].add(j+1);
                    graph[j+1].add(i+1);
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int node) {
        visited[node] = true;
        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
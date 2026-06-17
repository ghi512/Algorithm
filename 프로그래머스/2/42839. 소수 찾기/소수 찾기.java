import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    static char[] cards;
        
    public int solution(String numbers) {
        cards = numbers.toCharArray();
        visited = new boolean[cards.length];
        
        dfs("");
        int answer = 0;
        
        for(int num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(String current) {
        if(!"".equals(current)) {
            set.add(Integer.parseInt(current));
        }
        
        for(int i=0; i<cards.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(current + cards[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
}
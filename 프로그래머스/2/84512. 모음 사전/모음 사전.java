import java.util.*;

class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static int cnt = 0;
    static int answer = 0;
    static String target;
    
    public int solution(String word) {
        target = word;
        dfs("");
        return answer;
    }
    
    public void dfs(String current) {
        if(target.equals(current)) {
            answer = cnt;
            return;
        }
        
        if(current.length() == 5) {
            return;
        }
        
        for(int i=0; i<vowels.length; i++) {
            cnt++;
            dfs(current + vowels[i]);
        }
    }
}
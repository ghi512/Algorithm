import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            q.offer(new int[] {i, priorities[i]});
        }
        
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] current = q.poll();            
            boolean hasHigher = false;
            
            for(int[] process : q) {
                if(process[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher) {
                q.offer(current);
            } else {
                cnt++;
                if(current[0] == location) {
                    return cnt;
                }
            }
        }
        
        return -1;
    }
}
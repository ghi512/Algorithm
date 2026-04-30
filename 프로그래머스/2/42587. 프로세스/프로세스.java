import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        
        // (우선순위, 인덱스)
        for(int i=0; i<priorities.length; i++) {
            q.offer(new int[] {priorities[i], i});
        }
        
        int order = 0;
        while(true) {
            int[] now = q.poll();
            
            boolean higher = false;
            for(int[] p : q) {
                if(p[0] > now[0]) {
                    higher = true;
                    break;
                }
            }
            
            if(higher) {
                q.offer(now);
            }
            else {
                order++;
                if(now[1] == location) {
                    return order;
                }
            }
        }
        
    }
}
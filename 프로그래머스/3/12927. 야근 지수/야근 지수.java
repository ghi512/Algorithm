import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b.compareTo(a)
        );
        
        for(int w : works) {
            pq.offer(w);
        }
        
        int left_hours = n;
        while(left_hours > 0 && !pq.isEmpty()) {
            left_hours--;
            
            int temp = pq.poll();
            if(temp == 1) continue;
            
            pq.offer(temp - 1);
        }
        
        if(pq.isEmpty()) return 0;
        
        long answer = 0;
        while(!pq.isEmpty()) {
            int temp = pq.poll();
            answer += (temp * temp);
        }
        return answer;
    }
}
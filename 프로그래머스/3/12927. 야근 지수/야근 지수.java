import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        
        for(int w : works) {
            pq.offer(w);
        }
        
        while(n > 0 && !pq.isEmpty()) {
            int work = pq.poll() - 1;
            n--;
            
            if(work == 0) continue;
            
            pq.offer(work);
        }
        
        if(pq.isEmpty()) return 0;
        
        long answer = 0;
        while(!pq.isEmpty()) {
            int temp = pq.poll();
            answer += (long) Math.pow(temp, 2);
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    private static PriorityQueue<Integer> pq;
    
    public void mix() {
        int min1 = pq.poll();
        int min2 = pq.poll();
        
        pq.offer(min1 + (min2 * 2));
    }
    
    public int solution(int[] scoville, int K) {
        pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(pq.peek() < K) {
            if(pq.size() < 2) {
                answer = -1;
                break;
            }
            mix();
            answer++;
        }
        
        return answer;
    }
}
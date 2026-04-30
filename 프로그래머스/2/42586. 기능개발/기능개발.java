import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int n = progresses.length;
        
        for(int i=0; i<n; i++) {
            int leftDay = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0) leftDay++;
            q.offer(leftDay);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int now = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && q.peek() <= now) {
                q.poll();
                count++;
            }
            
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int left = 100 - progresses[i];
            if(left % speeds[i] == 0) {
                left /= speeds[i];
            } else {
                left = left / speeds[i] + 1;
            }
            q.offer(left);
        }
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        // 최초
        int prev = q.poll();
        int cnt = 1;
        
        while(!q.isEmpty()) {
            if(prev >= q.peek()) {
                q.poll();
                cnt++;
            }
            else {
                answerList.add(cnt);
                prev = q.poll();
                cnt = 1;
            }
        }
        answerList.add(cnt);
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
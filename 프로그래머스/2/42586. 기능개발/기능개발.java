import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 배포 가능 날짜를 담을 days 큐 선언
        ArrayDeque<Integer> days = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){            
            int n = (100-progresses[i]) % speeds[i] > 0 ? 
                (100-progresses[i]) / speeds[i] + 1 : (100-progresses[i]) / speeds[i];
            days.addLast(n);
        }
        days.addLast(-1); // 마지막 플래그 추가
        
        // 2. 배포 가능 날짜에 따라 기능수 계산해서 answer에 추가
        ArrayList<Integer> answer = new ArrayList<>();
        int function_nums = 1;
        int previous = days.pollFirst();
        
        while(!days.isEmpty()){
            int x = days.pollFirst();
            if (x < 0){
                answer.add(function_nums);
            }
            else if (previous < x){
                answer.add(function_nums);
                function_nums = 1;
                previous = x;
            }
            else {
                function_nums++;
            }
        }
        
        // 3. 정답 return 
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
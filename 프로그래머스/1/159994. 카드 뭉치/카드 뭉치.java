import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        // 1. cards1, cards2, goal 큐에 넣기
        ArrayDeque<String> cards1_q = new ArrayDeque<>();
        Arrays.stream(cards1).forEach(cards1_q::add);
        ArrayDeque<String> cards2_q = new ArrayDeque<>();
        Arrays.stream(cards2).forEach(cards2_q::add);
        
        // 2. 하나씩 꺼내서 goal과 비교
        String compare1 = cards1_q.pollFirst();
        String compare2 = cards2_q.pollFirst();
        
        for(String word:goal){            
            if(!cards1_q.isEmpty() && compare1 == "")
                compare1 = cards1_q.pollFirst();
            if(!cards2_q.isEmpty() && compare2 == "")
                compare2 = cards2_q.pollFirst();
                        
            if(compare1.equals(word)) {
                compare1 = "";
                continue;
            }
            else if(compare2.equals(word)){
                compare2 = "";
                continue;
            }
            else{
                answer = "No";
                break;
            }   
        }
        
        return answer;
    }
}
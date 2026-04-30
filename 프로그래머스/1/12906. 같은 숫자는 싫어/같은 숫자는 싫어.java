import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int a : arr) {
            if(!stack.empty() && stack.peek() == a) {
                continue;
            }
            stack.push(a);
        }
        
        int[] answer = new int[stack.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = stack.get(i);
        }
        
        return answer;
    }
}
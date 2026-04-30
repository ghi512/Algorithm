import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(') {
                stack.push('(');
                continue;
            }
            
            // ')'인 경우
            if(stack.empty()) {
                return false;
            }
            else {
                stack.pop();
            }
        }
        
        return stack.empty();        
    }
}
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        
        // 1. 문자열 s 한 문자씩 돌며 확인
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            // 1-1. '('이면 스택에 넣음
            if (ch == '(') {
                stack.push("(");
            }
            // 1-2. ')'이면서 스택이 비어있으면 false 반환
            else if (stack.isEmpty()) {
                return false;
            }
            // 1-3. ')'이면서 스택에 원소가 있으면 pop
            else {
                stack.pop();
            }
        }
        
        // 2. 스택의 사이즈가 1 이상이면 false, 아니면 true 반환
        if (stack.size() > 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
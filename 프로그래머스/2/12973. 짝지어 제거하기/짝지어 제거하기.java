import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        // 1. s를 한 문자씩 확인한다
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            // 2. 스택이 비어있지 않고, peek한 값이 c와 같으면 pop, 아니면 push한다   
            if(!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
    
        // 3. 스택이 비어있으면 1, 아니면 0 return
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}
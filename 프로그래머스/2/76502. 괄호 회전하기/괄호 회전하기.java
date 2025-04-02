import java.util.HashMap;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        // 1. 괄호 짝 맞게 정보 저장 (닫힌 괄호를 key로 저장)
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        int n = s.length();
        s += s;
        int answer = 0;
        
        // 2. n번 회전시키는 역할
        A:for(int i=0; i<n; i++){ // 시작 인덱스 변경
            ArrayDeque<Character> stack = new ArrayDeque<>();
            // 3. 현재 확인할 문자열 s[i] ~ s[i+n] 을 하나씩 확인
            for(int j=i; j<i+n; j++){
                char c = s.charAt(j);
                // 4. 해시맵 map에 key 없으면 열린 괄호이므로 put
                if(!map.containsKey(c)) {
                    stack.push(c);
                }
                else {
                    // 5. 닫힌 문자인데 현재 스택이 비엇거나 짝이 맞지않으면 continue
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            // 6. 모든 확인이 끝나고 스택이 비어있으면 올바른 괄호 문자열
            if(stack.isEmpty())
                answer++;
        }   
        return answer;
    }
}
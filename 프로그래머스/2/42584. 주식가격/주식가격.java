import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        // 1. 가격이 떨어지지 않은 기간 저장할 배열 선언
        int n = prices.length;
        int[] answer = new int[n];
        
        // 2. 가격 비교할 인덱스 담을 스택 선언
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        // 3. prices 순환 돌면서 하나씩 확인
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                // 4. 가격이 떨어졌으면 이전 가격의 기간 확정
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        // 5. 스택에 남아있으면 가격 떨어지지X
        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = (n-1) - j;
        }
        
        return answer;
    }
}
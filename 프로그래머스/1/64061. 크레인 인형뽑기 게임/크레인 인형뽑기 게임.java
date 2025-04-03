import java.util.Stack;
import java.util.HashMap;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
            
        // 1. board 값 넣을 HashMap 생성 (boardMap)
        HashMap<Integer, Stack<Integer>> boardMap = new HashMap<>();
        int n = board[0].length;
        for(int i=0; i<n; i++){
            boardMap.put(i+1, new Stack<>());
        }
        
        // 2. boardMap에 board 값 넣기 (n-1부터 0까지)
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n; j++){
                if(board[i][j] == 0) continue;
                boardMap.get(j+1).push(board[i][j]);
            }
        }
        
        // 3. 바구니 용 stack 생성 (basket)
        Stack<Integer> basket = new Stack<>();
        
        // 4. moves 하나씩 돌면서 boardMap.get(moves[i])이 비었는지 검사하고 아니면 pop하기
        for(int i=0; i<moves.length; i++){
            int toy = 0;
            if(boardMap.get(moves[i]).isEmpty()) continue;
            else {
               toy = boardMap.get(moves[i]).pop();
            }
            
            // 5. pop한 값이 basket의 peek과 같으면 answer +2 하고 pop
            if(!basket.isEmpty() && toy == basket.peek()) {
                answer += 2;
                basket.pop();
            }
            else{
                basket.push(toy);
            }
        }
        
    return answer;
    }
}
import java.util.*;

class Solution {
    static ArrayList<int[]> moves;
    
    public int[][] solution(int n) {
        moves = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        return moves.toArray(new int[0][]);
        
    }
    
    // n개의 원판을 from에서 to로 옮김. 이때 via(보조 기둥)을 활용
    public void hanoi(int n, int from, int to, int via) {
        // base case
        if(n == 1) {
            moves.add(new int[] {from, to});
            return;
        }
        
        hanoi(n-1, from, via, to); // 1. 위 n-1개를 보조기둥으로 옮김
        moves.add(new int[] {from, to}); // 2. 가장 큰 원반 이동 (from -> to);
        hanoi(n-1, via, to, from); // 3. n-1개를 목표기동으로
    }
}
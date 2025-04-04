import java.util.Stack;
import java.util.Arrays;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 1. 삭제된 행의 인덱스 저장할 스택 선언 (deleted)
        Stack<Integer> deleted = new Stack<>();
        
        // 2. 각 행의 위치를 표시하기 위한 배열 (up,down) (n+2 크기)
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        for(int i=0; i<n+2; i++){
            up[i] = i-1;
            down[i] = i+1;
        }
        
        // 3. 현재 위치 k (가상공간 고려해 +1)
        k++;
        
        // 4. cmd 하나씩 처리
        for(String c : cmd){
            // 5. 삭제 (C)
            if(c.startsWith("C")){
                deleted.push(k);
                down[up[k]] = down[k];
                up[down[k]] = up[k];
                
                if(down[k] > n) k = up[k];
                else k = down[k];
            }
            // 6. 복구 (Z)
            else if(c.startsWith("Z")){
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            // 7. 현재 위치 이동 (U x, D x)
            else{
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for(int i=0; i<x; i++){
                    if(s[0].equals("U")) k = up[k];
                    else k = down[k];
                }
            }
        }

        // 8. 처음 상태와 비교한 문자열 반환
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        for(int i: deleted){
            answer[i-1] = 'X';
        }
        
        return new String(answer);
    }
}
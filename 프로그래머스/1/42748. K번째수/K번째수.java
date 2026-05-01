import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++) {
            // 배열 내 인덱스로 변경
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            int[] temp = Arrays.copyOfRange(array, start, end+1);
            Arrays.sort(temp);
            answer[i] = temp[k];
        }
        
        return answer;
    }
}
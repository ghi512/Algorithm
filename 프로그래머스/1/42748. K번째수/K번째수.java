import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int[] c : commands) {
            int i = c[0]; int j = c[1]; int k = c[2];
            int[] temp = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(temp);
            answer[idx++] = temp[k-1];
        }
        
        return answer;
    }
}
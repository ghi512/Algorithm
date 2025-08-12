import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int len = d.length;
        int answer = 0;

        int sum = 0;
        for(int i : d) {
            sum += i;
        }

        if(sum <= budget) {
            answer = len;
        }
        else {
            for(int i=len-1; i>=0; i--) {
                sum -= d[i];
                if(sum <= budget) {
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}
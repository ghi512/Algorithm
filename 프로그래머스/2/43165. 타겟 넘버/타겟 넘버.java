import java.util.*;

class Solution {
    static int answer = 0;
    static int[] nums;
    static int targetNum;
    
    public int solution(int[] numbers, int target) {
        nums = numbers;
        targetNum = target;
        
        dfs(0,0);
        return answer;
    }
    
    public void dfs(int idx, int sum) {
        // 모든 숫자를 다 사용한 경우
        if(idx == nums.length) {
            if(sum == targetNum) {
                answer++;
            }
            return;
        }
        
        // 현재 숫자를 더하는 경우
        dfs(idx+1, sum + nums[idx]);
        
        // 현재 숫자를 빼는 경우
        dfs(idx+1, sum - nums[idx]);
    }
}
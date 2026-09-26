import java.util.*;

class Solution {
    static int target;
    static int index;
    static int answer = 0;
    static int[] numbers;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) {
                answer++;
                return;
            }
            return;
        }
        
        dfs(index+1, sum + numbers[index]);
        dfs(index+1, sum - numbers[index]);
    }
}
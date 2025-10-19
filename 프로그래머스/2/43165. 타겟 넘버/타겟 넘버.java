class Solution {
    int[] numbers;
    int target;
    int answer;
    
    void dfs(int index, int sum) {
        // 종료조건
        if(index == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        
        // 수행
        dfs(index+1, sum + numbers[index]);
        dfs(index+1, sum - numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        
        dfs(0,0);
        
        return answer;
    }
}
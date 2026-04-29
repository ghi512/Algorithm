class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[200]; // -100 ~ 100. arr[0]이 -100~-99
        
        for(int[] line : lines) {
            int a = line[0];
            int b = line[1];
            
            for(int i=a; i<b; i++) {
                arr[i+100]++;
            }
        }
        
        int answer = 0;
        for(int x : arr) {
            if(x >= 2) {
                answer++;
            }
        }
        
        return answer;
    }
}
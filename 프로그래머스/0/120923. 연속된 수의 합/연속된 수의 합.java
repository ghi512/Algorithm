class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int mid = total / num;
        int start = mid - (num-1) / 2;
        
        for(int i=0; i<num; i++) {
            answer[i] = start++;
        }
        
        return answer;
    }
}
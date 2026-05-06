class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int fin = common.length - 1;
        
        // 등차인지 등비인지 구분
        int diff1 = common[fin] - common[fin-1];
        int diff2 = common[fin-1] - common[fin-2];
        
        // 등차
        if(diff1 == diff2) {
            answer = common[fin] + diff1;
        }
        // 등비
        else {
            int mul = common[fin] / common[fin-1];
            answer = common[fin] + (diff1 * mul);
        }
        
        return answer;
    }
}
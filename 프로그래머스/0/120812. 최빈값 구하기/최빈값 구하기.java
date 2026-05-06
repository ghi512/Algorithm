class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1000]; // 0 ~ 999
        
        int max = -1;
        for(int a : array) {
            cnt[a]++;
            if(cnt[a] > max) max = cnt[a];
        }

        int answer = 0;
        for(int i=0; i<1000; i++) {
            if(answer > 0 && cnt[i] == max) {
                return -1;
            }
            else if(cnt[i] == max){
                answer = i;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지별 멈춰 있는 사람
        int[] count = new int[N+2];
        for(int s : stages) {
            count[s]++;
        }
        
        int total = stages.length; // 전체 사용자 수
        double[] failRate = new double[N+2]; // 실패율
        
        int remaining = total;
        for(int i=1; i<=N; i++) {
            if(remaining == 0) {
                failRate[i] = 0;
            }
            else {
                failRate[i] = (double) count[i] / remaining;
                remaining -= count[i];
            }
        }
        
        Integer[] stagesOrder = new Integer[N];
        for(int i=0; i<N; i++) {
            stagesOrder[i] = i+1;
        }
        
        Arrays.sort(stagesOrder, (a,b) -> {
            // 실패율이 같으면 번호 오름차순
            if(failRate[a] == failRate[b]) {
                return a-b;
            }
            // 실패율 내림차순
            return Double.compare(failRate[b], failRate[a]);
        });
        
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = stagesOrder[i];
        }
        
        return answer;
    }
}
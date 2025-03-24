import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 스테이지별 도전자 수 구함
        int[] challenger = new int[N+2];
        for(int i=0; i<stages.length; i++){
            challenger[stages[i]] += 1;
        }
        
        // 2. 스테이지별 실패한 사용자 수 계산
        HashMap<Integer,Double> fails = new HashMap<>();
        double total = stages.length;
        
        // 3. 각 스테이지를 순회하며 실패율 계산
        for(int i=1; i<=N; i++){
            // 3-1. 도전한 사람이 없으면 0
            if(challenger[i]==0){
                fails.put(i,0.);
            }
            // 3-2. 실패율 계산
            else{
                fails.put(i, challenger[i]/total);
                total -= challenger[i];
            }
        }
        
        // 4. 실패율이 높은 스테이지부터 내림차 순으로 정렬
        return fails.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey).toArray();
    }
}
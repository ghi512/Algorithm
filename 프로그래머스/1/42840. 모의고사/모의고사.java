import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        // 1. 수포자들의 정답 패턴 저장
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        // 2. 수포자들의 점수 저장 배열 선언
        int[] scores = new int[3];
        
        // 3. 정답과 수포자들의 패턴 비교 후 점수 저장
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<patterns.length; j++){
                if(answers[i] == patterns[j][i % patterns[j].length]){
                    scores[j]++;
                }
            }
        }
        
        // 4. 점수 최대값 구하기
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        // 5. 높은 점수값의 수포자 찾아 배열에 저장 (오름차순 정렬)
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<scores.length; i++){
            if(scores[i] == maxScore){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
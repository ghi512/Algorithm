import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int[] score = {0, 0, 0};
        int[][] method = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for(int i=0; i<3; i++) {
            int cnt = 0;
            for(int a : answers) {
                if(a == method[i][cnt % (method[i].length)]) {
                    score[i]++;
                }
                cnt++;
            }
        }
        
        int maxVal = Arrays.stream(score).max().getAsInt();
        for(int i=0; i<score.length; i++) {
            if(score[i] == maxVal) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
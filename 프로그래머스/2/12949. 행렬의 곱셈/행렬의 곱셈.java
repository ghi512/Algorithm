class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. answer 배열 생성 arr1[a][b] * arr2[b][c] -> answer[a][c]
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // 2. answer 값 구하기
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2[0].length; j++){
                for(int k=0; k<arr1[0].length; k++){
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        
        return answer;
    }
}
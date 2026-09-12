class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length; // 삼각형의 높이
        
        // dp[a][b] = (a,b)까지 오는 경로 중 가장 큰 합
        int[][] dp = new int[n][];
        for(int i=0; i<n; i++) {
            dp[i] = triangle[i].clone();
        }
        
        // 아래에서 두번째 행(n-2)부터 맨 위(0)까지 거꾸로
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                dp[i][j] = dp[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        
        return dp[0][0];
    }
}
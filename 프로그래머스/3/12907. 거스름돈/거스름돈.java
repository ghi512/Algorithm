class Solution {
    public int solution(int n, int[] money) {
        int MOD = 1_000_000_007;
        
        long[] dp = new long[n+1];
        dp[0] = 1;
        
        for(int m : money) {
            for(int i=m; i<=n; i++) {
                dp[i] += dp[i - m];
                dp[i] %= MOD;
            }
        }
        
        return (int) dp[n];
    }
}
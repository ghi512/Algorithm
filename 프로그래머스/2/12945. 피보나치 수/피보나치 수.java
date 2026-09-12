class Solution {
    // fibo[i] = i번째 피보나치 수를 1234567로 나눈 나머지
    static int[] fibo = new int[100_001];
    static int DIV = 1_234_567;
    
    public int solution(int n) {
        
        fibo[0] = 0;
        fibo[1] = 1;
        
        for(int i=2; i<=n; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % DIV;
        }
        
        return fibo[n];
    }
}
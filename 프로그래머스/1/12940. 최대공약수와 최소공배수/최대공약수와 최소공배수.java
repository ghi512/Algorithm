class Solution {
    public int[] solution(int n, int m) {
        return new int[] {gcd(n,m), lcm(n,m)};
    }
    
    public int gcd(int a, int b) {
        // base case : b가 0이면 a가 최대공약수임
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a%b);
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a,b);
    }
}
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 분자, 분모
        int child = (numer1 * denom2) + (numer2 * denom1);
        int parent = denom1 * denom2;
        int gcd = gcd(child, parent);
        
        return new int[] {child/gcd, parent/gcd};
    }
    
    private static int gcd(int a, int b) {
        while(b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
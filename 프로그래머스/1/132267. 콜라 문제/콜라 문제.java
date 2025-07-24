class Solution {
    public int solution(int a, int b, int n) {
        int totalCoke = 0;
        int emptyBottles = n;
        
        while(emptyBottles >= a) {
            int newCoke = (emptyBottles / a) * b;
            totalCoke += newCoke;
            emptyBottles = newCoke + (emptyBottles % a);
        }
        
        return totalCoke;
    }
}
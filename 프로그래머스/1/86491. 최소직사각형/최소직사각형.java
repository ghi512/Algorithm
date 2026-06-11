class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0; // 긴 변
        int maxH = 0; // 짧은 변
        
        for(int[] card : sizes) {
            maxW = Math.max(maxW, Math.max(card[0], card[1]));
            maxH = Math.max(maxH, Math.min(card[0], card[1]));
        }
        
        return maxW * maxH;
    }
}
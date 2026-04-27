class Solution {
    public int solution(int[][] dots) {
        if(isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if(isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if(isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        
        return 0;
    }
    
    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        // (y2 - y1) / (x2 - x1) == (y4 - y3) / (x4 - x3)
        // (y2 - y1) * (x4 - x3) == (y4 - y3) * (x2 - x1)
        
        return (b[1] - a[1]) * (d[0] - c[0]) == 
            (d[1] - c[1]) * (b[0] - a[0]);
    }
}
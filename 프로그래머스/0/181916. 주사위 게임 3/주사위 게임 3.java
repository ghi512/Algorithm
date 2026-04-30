import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);        
        
        // 1. 모두 같은 숫자인 경우 = 1111 * p
        if(arr[0] == arr[3]) {
            return 1111 * arr[0];
        }
        
        // 2. 세 면의 숫자가 같은 경우 = (10 * p + q)^2
        // 2.1. 앞 세개
        if(arr[0] == arr[2]) {
            int p = arr[0];
            int q = arr[3];
            return (int)Math.pow(10*p + q, 2);
        }
        // 2.2. 뒤 세개
        if(arr[1] == arr[3]) {
            int p = arr[1];
            int q = arr[0];
            return (int)Math.pow(10*p + q, 2);
        }
        
        
        // 3. 두 면씩 같은 숫자가 나온 경우 = (p+q) * abs(p-q)
        if(arr[0] == arr[1] && arr[2] == arr[3]) {
            int p = arr[0];
            int q = arr[2];
            return (p+q) * Math.abs(p-q);
        }
        
        // 4. 두 면은 같고, 나머지는 다른 경우 = q * r
        if(arr[0] == arr[1]) {
            return arr[2] * arr[3];
        }
        if(arr[1] == arr[2]) {
            return arr[0] * arr[3];
        }
        if(arr[2] == arr[3]) {
            return arr[0] * arr[1];
        }
        
        // 5. 모두 다른 경우 = min
        return arr[0];
    }
}
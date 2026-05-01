import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 내림차순 정렬
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }
        
        // 예외처리
        if(sb.charAt(0) == '0') return "0";
        
        return sb.toString();
        
    }
}
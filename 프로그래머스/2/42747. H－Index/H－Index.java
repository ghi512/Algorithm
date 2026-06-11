import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] arr = new Integer[citations.length];
        for(int i=0; i<citations.length; i++) {
            arr[i] = citations[i];
        }
        
        Arrays.sort(arr, (a,b) -> b-a); // [6, 5, 3, 1, 0]
        
        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= i+1) {
                answer = i+1;
            }
        }
        
        return answer;
    }
}
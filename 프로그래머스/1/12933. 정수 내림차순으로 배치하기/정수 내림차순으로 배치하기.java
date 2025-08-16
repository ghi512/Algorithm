import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        // long -> String -> Character[]
        String str = String.valueOf(n);
        Character[] arr = new Character[str.length()];
        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i);
        }
        
        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        
        // Character[] -> StringBuilder -> long
        StringBuilder sb = new StringBuilder();
        for(char c: arr) {
            sb.append(c);
        }
        long answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}
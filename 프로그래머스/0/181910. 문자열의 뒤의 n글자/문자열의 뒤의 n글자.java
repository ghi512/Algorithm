import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        int len = my_string.length();
        char[] strArr = my_string.toCharArray();
        
        String answer = "";
        for(int i = len-n; i<len; i++) {
            answer += strArr[i];
        }
        
        return answer;
    }
}
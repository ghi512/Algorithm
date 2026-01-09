import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] splitedStr = s.split(" ", -1);
        int strLength = splitedStr.length;
        
        for(int i=0; i<strLength; i++) {
            String word = splitedStr[i];
            for(int j=0; j<word.length(); j++) {
                String check = word.charAt(j) + "";
                if(j % 2 == 0) { // 짝수
                    answer += check.toUpperCase();
                } else {
                    answer += check.toLowerCase();
                }
            }
            if(i < strLength - 1) {
                answer += " ";
            }
        }
        
        return answer;
    }
}
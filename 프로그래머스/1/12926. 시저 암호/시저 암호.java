class Solution {
    public String solution(String s, int n) {
        char[] arr = new char[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                arr[i] = ' ';
            }
            // 소문자
            else if(c >= 'a' && c <= 'z') {
                int idx = (c - 'a' + n) % 26;
                arr[i] = (char) (idx + 'a');
            }
            // 대문자
            else {
                int idx = (c - 'A' + n) % 26;
                arr[i] = (char)(idx + 'A');
            }
        }
        
        return String.valueOf(arr);
    }
}
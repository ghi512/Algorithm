class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};        
        int answer = 0;
        
        for(String b : babbling) {
            int i = 0;
            
            while(i < b.length()) {
                boolean matched = false;
                
                for(String word : words) {
                    if(i + word.length() <= b.length()
                      && b.substring(i, i+word.length()).equals(word)) {
                        i += word.length();
                        matched = true;
                        break;
                    }
                }
                
                if(!matched) break;
            }
            
            if(i == b.length()) answer++;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : participant) {
            map.put(s, map.getOrDefault(s,0) + 1);
        }
        
        for(String c : completion) {
            if(map.get(c) > 1) {
                map.put(c, map.get(c) - 1);
            }
            else {
                map.remove(c);
            }
        }
        
        for(String key : map.keySet()) {
            return key;
        }
        
        return "";
    }
}
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. completion으로 해시맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : completion){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        // 2. participant 순회
        for(String p : participant){
            // 3. key(이름) 없거나 value(사람수)가 0이면 해당 선수 return
            if (!map.containsKey(p) || map.get(p)==0) {
                return p;
            }
            else{
                map.put(p, map.get(p)-1);
            }
        }
        return null;
    }
}
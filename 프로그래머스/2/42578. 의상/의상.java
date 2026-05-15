import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for(int cnt: map.values()) {
            answer *= (cnt + 1); // 종류별 전체 경우 + 1(안씀)
        }
        
        return answer - 1; // 모두 안쓴 경우 제외
    }
}
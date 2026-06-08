import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 의상 종류의 개수 + 1(안 입는 경우) 고려해서 계산
        int answer = 1;
        for(int cnt : map.values()) {
            answer *= (cnt + 1);
        }
        
        return answer - 1;
    }
}
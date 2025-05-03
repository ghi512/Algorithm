import java.util.*;

class Solution {
    // 만들 수 있는 메뉴 구성과 총 주문 수 저장할 해시맵
    public static HashMap<Integer, HashMap<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        // courseMap 초기화
        courseMap = new HashMap<>(); // 각 코스 길이별 조합 저장
        for(int i : course) {
            courseMap.put(i, new HashMap<>());
        }
        
        // orders에서 가능한 모든 메뉴 조합 구하기
        for(String order : orders){
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray); // 조합 키 통일을 위해 오름차 정렬
            combinations(0, orderArray, ""); // 현재 확인중인 order의 모든 조합 확인 후 저장
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        // 모든 코스 후보에 대해
        for(HashMap<String, Integer> count: courseMap.values()) {
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o)) // 가장 빈도수 높은 조합
                .ifPresent(cnt -> count.entrySet() // 존재하면
                          .stream()
                           // 해당 조합의 주문 수가 최대값이고 1 이상이면
                          .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                          .forEach(entry -> answer.add(entry.getKey()))); // 저장
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    // 조합 만들기 함수 (재귀 함수로 구현)
    public static void combinations(int idx, char[] order, String result){
        if(courseMap.containsKey(result.length())){
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0)+1);
        }
        for(int i=idx; i<order.length; i++){
            combinations(i+1, order, result+order[i]);
        }
    }
}
import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 문자열 {{}, .. ,{}} 형태 -> 파싱
        String inner = s.substring(2, s.length()-2);
        String[] sets = inner.split("\\},\\{");
        
        // 집합 원소 개수 기준으로 오름차 정렬
        Arrays.sort(sets, (a,b) -> Integer.compare(
            a.split(",").length,
            b.split(",").length
        ));
        
        // 튜플에 숫자 담기
        List<Integer> tuple = new ArrayList<>(); // 순서 보장용
        Set<Integer> seen = new HashSet<>(); // 중복 제거용
        for(String set : sets) {
            String[] nums = set.split(",");
            for(String n : nums) {
                int num = Integer.parseInt(n);
                if(seen.add(num)) { // hashset에 값이 없으면 true 반환
                    tuple.add(num);
                }
            }
        }
        
        return tuple.stream().mapToInt(Integer::intValue).toArray();
    }
}
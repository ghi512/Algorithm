import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. report 돌면서 reportedMap 저장 (특정 유저를 신고한 유저를 저장하는 해시맵)
        HashMap<String, ArrayList<String>> reportedMap = new HashMap<>();
        for(String r: report){
            String[] s = r.split(" "); // s[0]은 유저id, s[1]은 신고된 id
            
            // reportedMap에 key 없으면 초기화
            if (!reportedMap.containsKey(s[1])){
                reportedMap.put(s[1], new ArrayList<>());
            }
            
            // 기존에도 신고한 유저면 추가X
            if (reportedMap.get(s[1]).contains(s[0])) {
                continue;
            }
            
            reportedMap.get(s[1]).add(s[0]);
        }
        
        // 2. 
        HashMap<String, Integer> alertMap = new HashMap<>();
        for(String s : id_list){
            alertMap.put(s,0);
        }
        
        // 3. reportedMap 돌면서 신고한 유저가 k이상이면 alertMap 값에 +1
        for(String s : id_list){
            ArrayList<String> reporters = new ArrayList<>();
            if(reportedMap.containsKey(s)){
                reporters = reportedMap.get(s);
            }
            if(reporters.size() < k){
                continue;
            }
            for(String reporter:reporters){
                alertMap.put(reporter, alertMap.get(reporter)+1);
            }
        }
        
        // 3. answer에 저장
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            answer[i] = alertMap.get(id_list[i]);
        }
        
        return answer;
    }
}
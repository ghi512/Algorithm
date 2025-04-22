import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        // 1. nickname 해시맵 생성
        HashMap<String, String> nickname = new HashMap<>();
        
        // 2. record 돌면서 nickname 확인
        for(String r: record){
            String[] s = r.split(" ");
            
            if(s[0].equals("Enter") || s[0].equals("Change")){
                nickname.put(s[1], s[2]);
            }
        }
        
        // 3. record 다시 돌면서 answer 배열에 출력값 넣기
        ArrayList<String> answer = new ArrayList<>();
        for(String r: record){
            String[] s = r.split(" ");
            if(s[0].equals("Enter")){
                answer.add(nickname.get(s[1]) + "님이 들어왔습니다.");
            }
            else if(s[0].equals("Leave")){
                answer.add(nickname.get(s[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        
        // 시작시간 기준 정렬
        Arrays.sort(plans, (a,b) -> 
                   Integer.compare(toMinutes(a[1]), toMinutes(b[1]))
                   );
        
        // 멈춘 과제 저장할 Stack - [과제이름, 남은시간]
        Stack<String[]> stack = new Stack<>();
        for(int i=0; i<plans.length - 1; i++) {
            String name = plans[i][0]; // 과제명
            int start = toMinutes(plans[i][1]); // 시작시간
            int playtime = Integer.parseInt(plans[i][2]); // 소요시간
            int nextStart = toMinutes(plans[i+1][1]);
            
            // 다음 과제 시작 전까지 사용 가능한 시간
            int available = nextStart - start;
            
            // 현재 과제를 끝낼수 있는 경우
            if(playtime <= available) {
                answer.add(name);
                
                // 남은 시간동안 멈춰둔 과제 최신순으로 처리(스택사용)
                int remain = available - playtime;
                while(remain > 0 && !stack.isEmpty()) {
                    String[] stopped = stack.pop();
                    int stoppedTime = Integer.parseInt(stopped[1]);
                    
                    // 멈춘 과제를 끝낼 수 있는 경우
                    if(stoppedTime <= remain) {
                        answer.add(stopped[0]);
                        remain -= stoppedTime;
                    }
                    // 끝낼 수 없는 경우
                    else {
                        stack.push(new String[] {
                            stopped[0],
                            String.valueOf(stoppedTime - remain)
                        });
                        remain = 0;
                    }
                }
            }
            // 현재 과제를 끝낼수 없는 경우 - 스택에 넣기
            else {
                int remain = playtime - available;
                stack.push(new String[] {
                    name,
                    String.valueOf(remain)
                });
            }
        }
        
        // 마지막 과제는 무조건 끝냄
        answer.add(plans[plans.length - 1][0]);
        
        // 그 뒤 멈춰둔 과제들은 최근 것부터 마무리
        while(!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }
        
        return answer.toArray(new String[0]);
    }
    
    public int toMinutes(String time) {
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]);
        int min = Integer.parseInt(temp[1]);
        return hour * 60 + min;
    }
}
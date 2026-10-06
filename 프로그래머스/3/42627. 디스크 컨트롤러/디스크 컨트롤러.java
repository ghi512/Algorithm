import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 모든 작업들에 번호 붙이고 요청시각 순서대로 정렬
        int[][] tasks = new int[jobs.length][3];
        for(int i=0; i<jobs.length; i++) {
            tasks[i][0] = i;
            tasks[i][1] = jobs[i][0];
            tasks[i][2] = jobs[i][1];
        }
        
        // [작업번호, 요청시각, 소요시간]
        Arrays.sort(tasks, (a,b) -> {
            if(a[1] != b[1]) {
                return Integer.compare(a[1], b[1]); // 요청시각 오름차순
            }
            return Integer.compare(a[0], b[0]);
        });
        
        // pq 생성 + 우선순위 기준 설정 
        // [작업번호, 요청시각, 소요시간] -> 2, 1, 0 순으로 확인
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
                // 소요시간이 작은 순
                if(a[2] != b[2]) return Integer.compare(a[2],b[2]);
                // 요청시각이 빠른 순
                if(a[1] != b[1]) return Integer.compare(a[1],b[1]);
                // 작업번호가 작은 순
                return Integer.compare(a[0],b[0]);
            }
        );
        
        // 변수 초기화
        int currentTime = 0;
        int index = 0;
        int cnt = 0;
        long total = 0;
        
        // 시간 돌면서 작업 수행
        // [작업번호, 요청시각, 소요시간] 
        while(cnt < jobs.length) {
            // 현재 시각까지 요청된 tasks를 pq에 넣기
            while(index < tasks.length 
                  && tasks[index][1] <= currentTime) {
                pq.offer(tasks[index]);
                index++;
            }
            
            // 대기 작업 없으면 다음 시각으로
            if(pq.isEmpty()) {
                currentTime = tasks[index][1];
                continue;
            }
            
            // 우선순위 높은 작업 꺼내서 수행
            int[] job = pq.poll();
            currentTime += job[2];
            
            total += (currentTime - job[1]);
            cnt++;
        }
        
        // 평균소요시간 반환
        return (int) (total / jobs.length);
    }
}
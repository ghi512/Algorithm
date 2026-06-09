import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> wait = new LinkedList<>();
        Queue<int[]> bridge = new LinkedList<>();
        
        for(int w : truck_weights) {
            wait.offer(w);
        }
        
        int totalWeight = 0; // 다리 위 트럭 무게
        int times = 0; // 경과 시간
        
        while(!wait.isEmpty() || !bridge.isEmpty()) {
            times++;
            
            // 현재 다리 위에 있는 모든 트럭들의 경과 시간 처리
            int size = bridge.size();
            for(int i=0; i<size; i++) {
                int[] truck = bridge.poll();
                
                // truck[0]은 트럭의 무게, truck[1]은 트럭의 경과 시간
                if(truck[1] + 1 > bridge_length) {
                    totalWeight -= truck[0];
                }
                else {
                    bridge.offer(new int[] {truck[0], truck[1] + 1});
                }
            }
            
            // 대기 트럭 중 더 넣을 수 있으면 넣기
            if(!wait.isEmpty() && bridge.size() < bridge_length) {
                if(wait.peek() + totalWeight <= weight) {
                    int truck = wait.poll();
                    bridge.offer(new int[] {truck, 1});
                    totalWeight += truck;
                }
            }
        }
        
        return times;
    }
}
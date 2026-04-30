import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 아무것도 없는 상태를 0 각각으로 표현
        Queue<Integer> bridge = new LinkedList<>();
        
        int time = 0;
        int currentWeight = 0;
        int idx = 0;
        
        for(int i=0; i<bridge_length; i++) {
            bridge.offer(0);
        }
        
        while(idx < truck_weights.length) {
            time++;
            
            // 다리에서 하나 나감
            currentWeight -= bridge.poll();
            
            // 다음 트럭
            if(currentWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx++];
            }
            else {
                bridge.offer(0);
            }
        }
        
        // 마지막 트럭 나가는 시간
        return time + bridge_length;
    }
}
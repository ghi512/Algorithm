import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 현재 입차 중인 차량
        Map<String, Integer> inMap = new HashMap<>();
        // 차량별 누적 주차시간
        Map<String, Integer> totalTime = new HashMap<>();
        
        for(String record : records) {
            // 05:34 5961 IN
            String[] parts = record.split(" ");
            
            String time = parts[0];
            String car = parts[1];
            String state = parts[2];
            
            int mins = toMinutes(time); // 05:34 형태
            
            // 입차시간 저장
            if(state.equals("IN")) {
                inMap.put(car, mins);
            }
            // 출차시 누적 주차시간 저장하기
            else {
                int inTime = inMap.get(car);
                int parkingTime = mins - inTime;
                
                totalTime.put(
                    car,
                    totalTime.getOrDefault(car,0) + parkingTime
                );
                
                inMap.remove(car); // 출차했으므로 제거
            }
        }
        
        // 출차하지 않은 차량 처리
        int endOfDay = 23 * 60 + 59;
        for(String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            int parkingTime = endOfDay - inTime;
            
            totalTime.put(
                car,
                totalTime.getOrDefault(car,0) + parkingTime
            );
        }
        
        // 차량번호 오름차순 정렬
        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        for(int i=0; i<cars.size(); i++) {
            String car = cars.get(i);
            int totalMinutes = totalTime.get(car);
            
            answer[i] = calculateFee(totalMinutes, fees);
        }
        
        return answer;
    }
    
    // "05:34" -> 334분
    public int toMinutes(String time) {
        String[] s = time.split(":");
        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);
        return hour * 60 + minute;
    }
    
    // 최종 요금 계산
    public int calculateFee(int mins, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(mins <= basicTime) {
            return basicFee;
        }
        
        int extraTime = mins - basicTime;
        int units = (int) Math.ceil((double)extraTime / unitTime);
        
        return basicFee + units * unitFee;
    }
}
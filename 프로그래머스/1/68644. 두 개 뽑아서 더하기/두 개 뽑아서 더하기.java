import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> temp = new ArrayList<>();
        int len = numbers.length;
        
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                temp.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = temp.stream()
            .distinct()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}
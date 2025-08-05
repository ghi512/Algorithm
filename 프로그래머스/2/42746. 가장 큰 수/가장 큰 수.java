import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i=0; i<nums.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        
        String answer = "";
        Arrays.sort(nums, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        for(int i=0; i<nums.length; i++) {
            answer += nums[i];
        }
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
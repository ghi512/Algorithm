import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        int len = numbers.length;
        
        int[] sum = new int[len * (len-1) / 2];
        int cnt = 0;
        
        for(int i=0; i<len-1; i++) {
            for(int j=i+1; j<len; j++) {
                sum[cnt++] = numbers[i] + numbers[j];
            }
        }
        
        sum = Arrays.stream(sum)
            .boxed()
            .distinct()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return sum;
    }
}
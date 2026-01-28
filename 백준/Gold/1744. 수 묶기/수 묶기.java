import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for(int i=0; i<n; i++) {
            int temp = sc.nextInt();

            if(temp == 1) {
                one++;
            }
            else if(temp > 0) {
                plusQ.add(temp);
            }
            else if (temp < 0) {
                minusQ.add(temp);
            }
            else {
                zero++;
            }
        }

        int answer = 0;

        while(plusQ.size() > 1) {
            int a = plusQ.remove();
            int b = plusQ.remove();
            answer += (a * b);
        }
        if(!plusQ.isEmpty()) {
            answer += plusQ.remove();
        }

        while(minusQ.size() > 1) {
            int a = minusQ.remove();
            int b = minusQ.remove();
            answer += (a * b);
        }
        if(!minusQ.isEmpty()) {
            if(zero == 0) {
                answer += minusQ.remove();
            }
        }

        answer += one;
        System.out.println(answer);
    }
}
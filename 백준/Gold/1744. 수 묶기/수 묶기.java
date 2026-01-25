import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); // 1보다 큰 양수 (내림차순 정렬)
        PriorityQueue<Integer> minusPq = new PriorityQueue<>(); // 음수
        int one = 0; // 1의 개수
        int zero = 0; // 0의 개수

        for(int i=0; i<N; i++) {
            int data = sc.nextInt();
            if(data > 1) {
                plusPq.add(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusPq.add(data);
            }
        }

        int sum = 0;

        // 양수 묶음 처리
        while(plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += (first * second);
        }
        if(!plusPq.isEmpty()) {
            sum += plusPq.remove();
        }

        // 음수 묶음 처리
        while(minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += (first * second);
        }
        if(!minusPq.isEmpty()) {
            if(zero == 0) {
                sum += minusPq.remove();
            }
        }

        // 1 처리
        sum += one;
        System.out.println(sum);
    }
}
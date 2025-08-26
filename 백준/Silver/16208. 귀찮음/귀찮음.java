import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long sum = 0;

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr.add(temp);
            sum += temp;
        }
        Collections.sort(arr);

        long answer = 0;
        for (int a : arr) {
            sum -= a;
            answer += a * sum;
        }

        System.out.println(answer);
    }
}
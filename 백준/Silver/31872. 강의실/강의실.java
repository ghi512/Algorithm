import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] list = new int[n+1];
        list[0] = 0;
        for(int i=1; i<n+1; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);

        ArrayList<Integer> time = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            time.add(list[i] - list[i-1]);
        }
        Collections.sort(time, Collections.reverseOrder());

        int flag = 0;
        int answer = 0;
        for(int i=0; i<n; i++) {
            flag++;
            if(flag <= k) continue;
            answer += time.get(i);
        }

        System.out.println(answer);

    }
}

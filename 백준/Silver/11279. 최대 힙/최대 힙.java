import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            x = sc.nextInt();
            if(x==0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.offer(x);
            }
        }
    }
}

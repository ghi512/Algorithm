import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> q = new ArrayDeque<>();

        int n = sc.nextInt();
        String s = "";
        for(int i=0; i<n; i++) {
            s = sc.next();
            if(s.equals("push")) {
                int x = sc.nextInt();
                q.push(x);
            }
            else if(s.equals("pop")) {
                if(q.isEmpty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(q.pollLast());
                }
            }
            else if(s.equals("size")) {
                System.out.println(q.size());
            }
            else if(s.equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println("1");
                }
                else {
                    System.out.println("0");
                }
            }
            else if(s.equals("front")) {
                if(q.isEmpty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(q.peekLast());
                }
            }
            else if(s.equals("back")) {
                if(q.isEmpty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(q.peekFirst());
                }
            }
        }
    }
}

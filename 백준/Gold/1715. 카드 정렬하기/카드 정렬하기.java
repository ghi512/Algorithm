import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(q.size() > 1) {

            int a = q.remove();
            int b = q.remove();
            int temp = a + b;
            q.add(temp);
            answer += temp;
        }

        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N,M; // 레슨수, 레슨길이
        int[] lesson;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lesson = new int[N];
        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;

        for(int i=0; i<N; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            if(start < lesson[i]) {
                start = lesson[i];
            }
            end += lesson[i];
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for(int i=0; i<N; i++) {
                if(sum + lesson[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += lesson[i];
            }

            if(sum != 0) count++;
            if(count > M) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
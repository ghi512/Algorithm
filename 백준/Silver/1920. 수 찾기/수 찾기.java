import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m;
        int[] arr, check;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        check = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            int nowCheck = check[i];
            int startIdx = 0;
            int endIdx = n-1;
            int middleIdx;

            while(true) {
                middleIdx = (startIdx + endIdx) / 2;
                if(startIdx > endIdx || startIdx >= n || endIdx >= n || middleIdx >= n) {
                    System.out.println("0");
                    break;
                }

                if(arr[middleIdx] == nowCheck) {
                    System.out.println("1");
                    break;
                }
                else if (arr[middleIdx] > nowCheck) {
                    endIdx = middleIdx - 1;
                }
                else if (arr[middleIdx] < nowCheck) {
                    startIdx = middleIdx + 1;
                }

            }
        }

    }
}
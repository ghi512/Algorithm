import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {            
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<N; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
            
            int max = -1;
            long result = 0;
            
            for(int i=arr.length-1; i>=0; i--) {
                int today = arr[i];
                if( today < max) {
                    result += (max - today);
                }
                else {
                    max = today;
                }
            }
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}
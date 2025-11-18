import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            
            arr[0][0] = 1;
            
            for(int i=1; i<n; i++) {
                for(int j=0; j<=i; j++) {
                    arr[i][j] = (j-1)<0 ? arr[i-1][j] : arr[i-1][j] + arr[i-1][j-1];
                }
            }
            
            System.out.println("#" + test_case);
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][j] > 0) {
                        System.out.print(arr[i][j] + " ");
                    }
                }
                System.out.println();
            }
		}
	}
}
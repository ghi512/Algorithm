import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = 0;
            for(int i=0; i<(n-m+1); i++) {
                for(int j=0; j<(n-m+1); j++) {
                    int sum = 0;
                    for(int k=i; k<i+m; k++) {
                        for(int l=j; l<j+m; l++) {
                            sum += arr[k][l];
                        }
                    }
                    if(sum>answer) answer = sum;
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		
		}
	}
}
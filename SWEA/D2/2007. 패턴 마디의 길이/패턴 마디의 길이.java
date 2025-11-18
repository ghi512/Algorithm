import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
            String sentence = br.readLine();
            int len = 0;
            
            for(int i=1; i<=sentence.length(); i++) {
                String sub1 = sentence.substring(0,i);
                String sub2 = sentence.substring(i,i+i);
                if(sub1.equals(sub2)) {
                    len = sub1.length();
                    break;
                }
            }
            
            System.out.println("#" + test_case + " " + len);            
		}
	}
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[10000001];
        for(int i=2; i<A.length; i++) {
            A[i] = i;
        }

        for(int i=2; i<Math.sqrt(A.length); i++) {
            if(A[i]==0) {
                continue;
            }
            for(int j=i*2; j<A.length; j+=i) {
                A[j] = 0;
            }
        }

        int index = N;
        while(true) {
            if(A[index] > 0) { // 1. 소수인가?
                int num = A[index];
                if(isPalindrome(num)) { // 2. 펠린드롬 수인가?
                    System.out.println(num);
                    break;
                }
            }
            index++;
        }
    }

    static boolean isPalindrome(int target) {
        char[] temp = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;

        while(s<e) {
            if(temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
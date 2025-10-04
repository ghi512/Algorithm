import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int digit = sc.nextInt();

        int count = 0;
        for(int i=1; i<=n; i++) {
            String s = Integer.toString(i);
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == Integer.toString(digit).charAt(0)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}


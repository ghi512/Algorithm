import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = (sc.nextInt() * sc.nextInt() * sc.nextInt());
        String str = Integer.toString(num);

        for(int i=0; i<=9; i++) {
            int cnt = 0;
            for(int j=0; j<str.length(); j++) {
                if ((str.charAt(j) - '0') == i) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}

import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] str = line.split("-");

        for(int i=0; i<str.length; i++) {
            int temp = mySum(str[i]);
            if(i==0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);
    }

    static int mySum(String s1) {
        int sum = 0;
        String[] s2 = s1.split("[+]");
        for(String s : s2) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
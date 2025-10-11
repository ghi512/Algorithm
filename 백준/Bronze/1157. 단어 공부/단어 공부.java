import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int[] alphabetNums = new int[26];

        for(int i=0; i<str.length(); i++) {
            alphabetNums[str.charAt(i) - 'A']++;
        }

        int max = -1;
        char index = 0;

        for(int i=0; i<alphabetNums.length; i++) {
            if(alphabetNums[i] > max) {
                max = alphabetNums[i];
                index = (char) (i + 'A');
            } else if (alphabetNums[i] == max) {
                index = '?';
            }
        }

        System.out.println(index);
    }
}

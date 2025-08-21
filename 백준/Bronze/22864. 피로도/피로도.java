import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();

        int tiredness = 0, workingTime = 0, temp = 0;

        for(int i=0; i<24; i++) {
            if (a > m) break;
            tiredness = Math.max(tiredness, 0);
            temp = tiredness + a;

            if(temp > m) {
                tiredness -= c;
            }
            else {
                workingTime++;
                tiredness = temp;
            }

        }

        System.out.println(workingTime * b);
    }
}
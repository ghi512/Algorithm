import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] squares = new int[n+2];
        squares[0] = 1;
        squares[1] = 1;

        for(int i = 2; i <= n+1; i++) {
            squares[i] = squares[i-2] + squares[i-1];
        }

        long answer = (long) squares[n-1] * 2 + squares[n] * 2;
        System.out.println(answer);
    }
}

import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m+1];
        printSeq(0, n, m, arr);
        System.out.println(sb);
    }

    private static void printSeq(int cnt, int n, int m, int[] arr) {
        if(cnt == m) {
            for(int i=0; i<arr.length-1; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++) {
            arr[cnt] = i;
            printSeq(cnt+1, n, m, arr);
            arr[cnt] = 0;
        }
    }


}
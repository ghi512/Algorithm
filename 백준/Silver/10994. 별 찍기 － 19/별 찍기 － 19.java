import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 2차원 배열 생성
        int len = 4 * (n - 1) + 1;
        char[][] arr = new char[len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                arr[i][j] = ' ';
            }
        }

        // 재귀함수 호출
        drawStar(arr, 0, n);

        // 출력
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawStar(char[][] arr, int start, int n) {
        if(n <= 0) return;

        int len = 4 * (n - 1) + 1;
        for(int i=start; i < start + len; i++) {
            arr[start][i] = '*';
            arr[i][start] = '*';
            arr[start + len-1][i] = '*';
            arr[i][start + len-1] = '*';
        }

        drawStar(arr, start+2, n-1);
    }
}

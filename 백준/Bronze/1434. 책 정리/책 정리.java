import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 박스의 개수
        int m = sc.nextInt();   // 책의 개수

        int[] boxes = new int[n];
        int[] books = new int[m];

        for(int i=0; i<n; i++) {
            boxes[i] = sc.nextInt();
        }

        for(int i=0; i<m; i++) {
            books[i] = sc.nextInt();
        }

        int idx = 0;
        for(int i=0; i< books.length; i++) {
            if(boxes[idx] >= books[i]) {
                boxes[idx] -= books[i];
            }
            else {
                idx++;
                i--;
            }
        }

        int answer = 0;
        for(int box : boxes) {
            answer += box;
        }

        System.out.println(answer);
    }
}
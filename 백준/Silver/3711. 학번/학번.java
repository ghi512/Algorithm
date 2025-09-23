import java.util.*;

public class Main {
    private static int T;   // 테스트케이스 수
    private static int G;   // 학생 수
    private static int[][] students;    // 학생별 학번
    private static HashSet<Integer> remains; // 학번을 m으로 나눈 나머지값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        students = new int[T][];
        remains = new HashSet<>();

        for(int i=0; i<T; i++) {
            G = sc.nextInt();
            students[i] = new int[G];
            for(int j=0; j<G; j++) {
                students[i][j] = sc.nextInt();
            }
            findRemain(students[i]);
        }

//        for(int i=0; i<T; i++) {
//            System.out.println(Arrays.toString(students[i]));
//        }
    }

    private static void findRemain(int[] students) {
        int remain = -1;
        int i = 1;

        while(true) {
            remains.clear();
            boolean answer = true;

            for(int s : students) {
                remain = s % i;
                if(!remains.add(remain)) {
                    answer = false;
                    break;
                }
            }

            if(answer) {
                System.out.println(i);
                return;
            }
            i++;
        }
    }
}


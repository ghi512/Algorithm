import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] timetable = new int[N][2];
        for(int i=0; i<N; i++) {
            timetable[i][0] = sc.nextInt();
            timetable[i][1] = sc.nextInt();
        }

        Arrays.sort(timetable, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if(S[1] == E[1]) { // 종료시간이 같을 때
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });

        int cnt = 0;
        int end = -1;
        for(int i=0; i<N; i++) {
            if(timetable[i][0] >= end) {
                end = timetable[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
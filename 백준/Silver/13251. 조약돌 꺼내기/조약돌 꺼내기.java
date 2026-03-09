import java.util.*;

public class Main {
    static int M, K, sum;
    static int[] stone;
    static double[] probability;
    static double answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        sum = 0;
        answer = 0.0;
        stone = new int[M];
        probability = new double[M];

        for(int i=0; i<M; i++) {
            stone[i] = sc.nextInt();
            sum += stone[i];
        }
        K = sc.nextInt();

        for(int i=0; i<M; i++) {
            // 선택 조약돌 개수 K보다 현재 색 조약돌 개수 stone[i]가 적으면 모두 같은 색으로 뽑을 확률은 0임
            if(stone[i] >= K) {
                probability[i] = 1.0;
                // i색을 모두 뽑을 확률
                for(int j=0; j<K; j++) {
                    probability[i] *= (double) (stone[i] - j) / (sum - j);
                }
            }
            answer += probability[i];
        }

        System.out.println(answer);
    }
}
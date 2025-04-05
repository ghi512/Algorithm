import java.util.Scanner;
import java.util.ArrayDeque;

class Main {
    public static void main(String[] args){
        // 1. 입력받기 (N명의 사람, K번째 제거)
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 2. 사람들 deque에 넣기
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            deque.addLast(i+1);
        }

        // 3. 제거된 사람들 넣을 ArrayDeque 선언
        ArrayDeque<Integer> deleted = new ArrayDeque<>();

        // 4. 아무도 남지 않을 때까지 제거 반복
        while(deque.size() > 0){
            for(int i=0; i<K-1; i++){
                deque.addLast(deque.pollFirst());
            }
            deleted.addLast(deque.pollFirst());
        }

        System.out.println("<" + String.join(", ", deleted.stream().map(String::valueOf).toArray(String[]::new)) + ">");
    }
}
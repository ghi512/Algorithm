import java.util.*;

public class Main {

    static int A, B, C;
    static boolean[][] visited;
    static boolean[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        visited = new boolean[A+1][B+1];
        result = new boolean[C+1];

        BFS();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=C; i++) {
            if(result[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0}); // (a,b)
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int a = now[0];
            int b = now[1];
            int c = C - a - b;

            if(a==0) {
                result[c] = true;
            }

            // 6가지 이동 경우
            // A -> B
            move(a, b, c, Math.min(a, B-b), 0, 1, q);

            // A -> C
            move(a, b, c, Math.min(a, C-c), 0, 2, q);

            // B -> A
            move(a, b, c, Math.min(b, A-a), 1, 0, q);

            // B -> C
            move(a, b, c, Math.min(b, C-c), 1, 2, q);

            // C -> A
            move(a, b, c, Math.min(c, A-a), 2, 0, q);

            // C -> B
            move(a, b, c, Math.min(c, B-b), 2, 1, q);
        }
    }

    static void move(int a, int b, int c, int amount, int from, int to, Queue<int[]> q) {
        int[] cups = {a, b, c};
        cups[from] -= amount;
        cups[to] += amount;

        int na = cups[0];
        int nb = cups[1];

        if(!visited[na][nb]) {
            visited[na][nb] = true;
            q.offer(new int[] {na, nb});
        }
    }
}
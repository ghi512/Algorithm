import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K, X;
    static ArrayList<Integer>[] list;
    static int[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        // 그래프 생성
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 그래프 정보 저장
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list[S].add(E);
        }

        // 방문배열 초기화
        visited = new int[N+1];
        for(int i=1; i<=N; i++) {
            visited[i] = -1;
        }

        answer = new ArrayList<>();
        BFS(X);

        for(int i=1; i<=N; i++) {
            if(visited[i] == K) {
                answer.add(i);
            }
        }

        if(answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for(int a : answer) {
                System.out.println(a);
            }
        }
    }

    private static void BFS(int Node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(Node);
        visited[Node]++;

        while(!q.isEmpty()) {
            int nowNode = q.poll();
            for(int i : list[nowNode]) {
                if(visited[i] == -1) {
                    visited[i] = visited[nowNode] + 1;
                    q.add(i);
                }
            }
        }
    }
}
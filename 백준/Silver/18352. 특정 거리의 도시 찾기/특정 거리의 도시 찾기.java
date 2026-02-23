import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] list;
    static int[] visited;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new int[N+1];
        for(int i=1; i<=N; i++) {
            visited[i] = -1;
        }

        answer = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        BFS(X);

        for(int i=1; i<=N; i++) {
            if(visited[i] == K) {
                answer.add(i);
            }
        }

        if(answer.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);
            for(int i : answer) {
                System.out.println(i);
            }
        }

    }

    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start]++;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i : list[now]) {
                if(visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    q.add(i);
                }
            }
        }
    }
}
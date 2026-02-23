import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[N+1];

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }

        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            answer[i] = BFS(i);
        }

        int maxVal = 0;
        for(int i=1; i<=N; i++) {
            maxVal = Math.max(answer[i], maxVal);
        }

        for(int i=1; i<=N; i++) {
            if(answer[i] == maxVal) {
                bw.write(i + " ");
            }
        }

        bw.flush();
    }

    static int BFS(int check) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(check);
        visited[check] = true;

        int cnt = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i : list[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
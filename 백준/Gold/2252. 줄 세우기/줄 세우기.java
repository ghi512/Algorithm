import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for(int next : list[now]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

    }
}
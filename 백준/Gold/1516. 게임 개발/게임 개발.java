import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static int[] times;
    static int[] indegree;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        times = new int[N+1];
        indegree = new int[N+1];
        answer = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == -1) {
                    break;
                }
                list[temp].add(i);
                indegree[i]++;
            }
        }

        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : list[now]) {
                indegree[next]--;
                answer[next] = Math.max(answer[next], answer[now] + times[now]);
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            System.out.println(answer[i] + times[i]);
        }
    }
}
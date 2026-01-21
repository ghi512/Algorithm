import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] list; // 인접리스트
    static boolean[] visited; // 방문배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1]; // 정점의 개수 + 1개만큼 생성 (1~n까지 기록할 수 있도록)
        visited = new boolean[n+1];

        // 인접리스트 초기화
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 간선의 개수만큼 반복 실행
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        int count = 0;
        for(int i=1; i<n+1; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    static void DFS(int v) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        for(int i : list[v]) {
            if(visited[i] == false) {
                DFS(i);
            }
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arrive = false;

        list = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i< n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<n; i++) {
            DFS(i, 1);
            if(arrive) break;
        }

        if(arrive) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }

    public static void DFS(int now, int depth) {
        if(depth == 5) {
            arrive = true;
            return;
        }

        visited[now] = true;
        for(int i : list[now]) {
            if(!visited[i]) {
                DFS(i, depth+1);
            }
        }
        visited[now] = false;
    }
}

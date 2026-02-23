import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        for(int t=0; t<K; t++) {
            int V, E;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new boolean[V+1];
            check = new int[V+1];
            isEven = true;

            list = new ArrayList[V+1];
            for(int i=1; i<=V; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            for(int i=1; i<=V; i++) {
                if(isEven) {
                    DFS(i);
                }
                else {
                    break;
                }
            }

            if(isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void DFS(int node) {
        visited[node] = true;
        for(int i : list[node]) {
            if(!visited[i]) {
                // 인접한 노드는 같은 집합이 아님 -> 이전 노드와 다른 집합으로 처리
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            // 이미 방문한 노드가 현재 노드와 같은 집합이면 이분 그래프가 아님
            else if(check[i] == check[node]){
                isEven = false;
            }
        }
    }
}
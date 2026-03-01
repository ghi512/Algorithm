import java.util.*;
import java.io.*;

public class Main {
    static int N, root, deletedNode;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for(int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
        }
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp == -1) {
                root = i;
            }
            else {
                tree[temp].add(i);
                tree[i].add(temp);
            }
        }

        deletedNode = Integer.parseInt(br.readLine());

        if(deletedNode == root) {
            System.out.println(0);
        }
        else {
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int node) {
        visited[node] = true;
        int children = 0;
        for(int i : tree[node]) {
            if(!visited[i] && i != deletedNode) {
                children++;
                DFS(i);
            }
        }
        // 자식노드가 없으면 리프 노드이므로 정답 증가
        if(children == 0) {
            answer++;
        }
    }
}
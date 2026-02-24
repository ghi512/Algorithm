import java.util.*;
import java.io.*;

public class Main {
    static int N, M, S, E;
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] reverse;
    static int[] indegree;
    static int[] result;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 초기화
        list = new ArrayList[N+1];
        reverse = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<Node>();
            reverse[i] = new ArrayList<Node>();
        }
        indegree = new int[N+1];
        result = new int[N+1];
        count = 0;
        visited = new boolean[N+1];

        // 인접리스트 정보 받기 (list, reverse, indegree 정보 저장)
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Node (b, v));
            reverse[b].add(new Node(a,v));
            indegree[b]++;
        }

        // 시작, 도착
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Node next : list[now]) {
                indegree[next.targetNode]--;
                result[next.targetNode]
                        = Math.max(result[next.targetNode], result[now] + next.value);
                if(indegree[next.targetNode] == 0) {
                    q.offer(next.targetNode);
                }
            }
        }

        // 위상정렬 역방향
        q = new LinkedList<>();
        q.offer(E);
        visited[E] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Node next : reverse[now]) {
                if(result[next.targetNode] + next.value == result[now]) {
                    count++;
                    if(visited[next.targetNode] == false) {
                        visited[next.targetNode] = true;
                        q.offer(next.targetNode);
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(result[E]);
        System.out.println(count);
    }

    static class Node {
        int targetNode;
        int value;

        Node (int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }
}
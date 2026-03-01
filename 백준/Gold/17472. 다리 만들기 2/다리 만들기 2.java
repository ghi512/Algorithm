import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;

    // 섬
    static int islandNum;
    static ArrayList<ArrayList<int[]>> islandList;
    static ArrayList<int[]> oneIsland;

    // BFS용
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    // 유니온 파인드용
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        // 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st =  new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS 수행 -> 섬 구분
        islandNum = 1;
        islandList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    BFS(i,j);
                    islandNum++;
                    islandList.add(oneIsland);
                }
            }
        }

        // 모든 섬에서 상하좌우로 다리 찾아 Edge 리스트에 저장
        for(int i=0; i<islandList.size(); i++) {
            ArrayList<int[]> now = islandList.get(i);
            for(int j=0; j<now.size(); j++) {
                int x = now.get(j)[0];
                int y = now.get(j)[1];
                int nowIslandNum = map[x][y];

                for(int d =0; d<4; d++) {
                    int tempX = dx[d];
                    int tempY = dy[d];
                    int bridgeLen = 0;

                    int checkX = x+tempX;
                    int checkY = y+tempY;

                    while(checkX >=0 && checkX <N && checkY >=0 && checkY <M) {
                        // 같은 섬인 경우
                        if(map[checkX][checkY] == nowIslandNum) {
                            break;
                        }
                        // 다른 섬인 경우
                        else if(map[checkX][checkY] != 0) {
                            if(bridgeLen > 1) {
                                pq.add(new Edge(nowIslandNum, map[checkX][checkY], bridgeLen));
                            }
                            break;
                        }
                        // 바다인 경우
                        else {
                            bridgeLen++;
                        }

                        checkX += tempX;
                        checkY += tempY;
                    }
                }
            }
        }

        // parent 배열 초기화
        parent = new int[islandNum];
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        // MST
        int useEdge = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if(find(now.s) != find(now.e)) {
                union(now.s, now.e);
                answer += now.v;
                useEdge++;
            }
        }

        // 결과 출력
        if(useEdge == islandNum-2) {
            System.out.println(answer);
        }
        else {
            System.out.println("-1");
        }
    }

    public static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        oneIsland = new ArrayList<>();
        int[] start = {i,j};

        q.add(start);
        oneIsland.add(start);
        visited[i][j] = true;
        map[i][j] = islandNum;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int d=0; d<4; d++) {
                int tempX = dx[d];
                int tempY = dy[d];

                int checkX = x+tempX;
                int checkY = y+tempY;

                while(checkX >=0 && checkX <N && checkY >=0 && checkY <M) {
                    if(!visited[checkX][checkY] && map[checkX][checkY] != 0) {
                        addNode(checkX, checkY, q);
                    }
                    else {
                        break;
                    }

                    checkX += tempX;
                    checkY += tempY;
                }
            }
        }
    }

    public static void addNode(int x, int y, Queue<int[]> q) {
        map[x][y] = islandNum;
        visited[x][y] = true;
        int[] temp = {x,y};
        q.add(temp);
        oneIsland.add(temp);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    public static int find(int n) {
        if(n == parent[n]) {
            return n;
        }
        else {
            return parent[n] = find(parent[n]);
        }
    }

    public static class Edge implements Comparable<Edge> {
        int s, e, v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge e)  {
            return this.v - e.v;
        }
    }
}
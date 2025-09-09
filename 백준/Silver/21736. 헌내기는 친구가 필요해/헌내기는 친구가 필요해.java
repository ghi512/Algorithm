import java.util.Scanner;

public class Main {
    static int n,m;
    static int answer = 0;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new char[n][m];
        visited = new boolean[n][m];

        int ix=0, iy=0;

        for(int i=0; i<n; i++) {
            String line = sc.nextLine();
            for(int j=0; j<m; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'I') {
                    ix = i; iy = j;
                }
            }
        }

        dfs(ix,iy);

        if(answer == 0) System.out.println("TT");
        else System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        // 범위 밖인 경우
        if(x<0 || y<0 || x>=n || y>=m) return;
        // 방문한 경우
        if(visited[x][y]) return;
        // 벽인 경우
        if(map[x][y] == 'X') return;

        visited[x][y] = true;
        if(map[x][y] == 'P') answer++;

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            dfs(nx, ny);
        }
    }
}

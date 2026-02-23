import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K; // 사람 수, 파티 수, 진실을 아는 사람 수
    static int[] parent;
    static int[] trueP;
    static ArrayList<Integer>[] party;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        trueP = new int[K];
        for(int i=0; i<K; i++) {
            trueP[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        party = new ArrayList[M];
        for(int i=0; i<M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int party_size = Integer.parseInt(st.nextToken());
            for(int j=0; j<party_size; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        for(int i=0; i<M; i++) {
            int firstP = party[i].get(0);
            for(int j=1; j<party[i].size(); j++) {
                union(firstP, party[i].get(j));
            }
        }

        for(int i=0; i<M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j=0; j<trueP.length; j++) {
                if(find(cur) == find(trueP[j])) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int n) {
        if(n == parent[n]) {
            return n;
        }
        else {
            return parent[n] = find(parent[n]);
        }
    }
}
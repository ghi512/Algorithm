import java.util.*;
import java.io.*;

public class Main {
    static int N, M, X; // 노드수, 변경횟수, 구간곱횟수
    static int K, leafStartIdx, treeSize;
    static int[] tree;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 인덱스 트리용 변수 초기화
        K = getK(N);
        treeSize = (int) Math.pow(2, K+1);
        leafStartIdx = (int) Math.pow(2, K);
        tree = new int[treeSize];
        Arrays.fill(tree, 1);

        // 리프노드 입력받기
        for(int i=leafStartIdx; i<leafStartIdx+N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        // 부모노드 채우기
        setTree();

        // 변경 or 구간곱
        for(int i=0; i<M+X; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 값 변경
            if(a==1) {
                changeVal(leafStartIdx+b-1, c);
            }
            // 구간곱 구하기
            else if(a==2) {
                System.out.println(getMul(leafStartIdx+b-1, leafStartIdx+c-1));
            }
        }
    }

    static int getMul(int s, int e) {
        long partMul = 1;

        while(s <= e) {
            if(s%2 == 1) {
                partMul = partMul * tree[s] % MOD;
            }
            if(e%2 == 0) {
                partMul = partMul * tree[e] % MOD;
            }

            s = (s+1) / 2;
            e = (e-1) / 2;
        }

        return (int) partMul;
    }

    static void changeVal(int idx, int val) {
        tree[idx] = val % MOD;
        while(idx > 1) {
            idx /= 2;
            tree[idx] = (int)(((long)tree[idx*2] * tree[idx*2 + 1]) % MOD);
        }
    }

    static void setTree() {
        for(int i=leafStartIdx-1; i>=1; i--) {
            tree[i] = (int)(((long)tree[i*2] * tree[i*2 + 1]) % MOD);
        }
    }

    static int getK(int n) {
        int value = 1;
        int k = 0;
        while(value < n) {
            value *= 2;
            k++;
        }
        return k;
    }
}
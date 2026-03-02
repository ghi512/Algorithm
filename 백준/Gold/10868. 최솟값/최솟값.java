import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int leafStartIdx, K, treeSize;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // K, leafStartIdx, treeSize 구하기
        K = getK(N);
        treeSize = (int) Math.pow(2, K+1);
        leafStartIdx = (int) Math.pow(2, K);

        // 트리 초기화
        tree = new int[treeSize];
        Arrays.fill(tree, Integer.MAX_VALUE);

        // 원본 배열 리프 노드에 넣기
        for(int i=leafStartIdx; i<leafStartIdx+N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        // 트리 채우기 (Min)
        setTree(treeSize - 1);

        // 질의 수행
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int startIdx = leafStartIdx + a - 1;
            int endIdx = leafStartIdx + b - 1;

            System.out.println(getMin(startIdx, endIdx));
        }
    }

    static int getMin(int s, int e) {
        int min = Integer.MAX_VALUE;
        while(s <= e) {
            if(s%2 == 1) {
                min = Math.min(min, tree[s]);
            }
            if(e%2 == 0) {
                min = Math.min(min, tree[e]);
            }

            s = (s+1) / 2;
            e = (e-1) / 2;
        }
        return min;
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

    static void setTree(int idx) {
        while(idx > 1) {
            if(tree[idx/2] > tree[idx]) {
                tree[idx/2] = tree[idx];
            }
            idx--;
        }
    }
}
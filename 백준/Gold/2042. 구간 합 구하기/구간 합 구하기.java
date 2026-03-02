import java.util.*;
import java.io.*;

public class Main {
    static int N, M, X; // 노드 개수, 변경 횟수, 구간합 횟수
    static int treeSize, K, leafTreeStart;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        K = getK(N);
        treeSize = (int) Math.pow(2, K +1);
        tree = new long[treeSize];
        leafTreeStart = (int) Math.pow(2, K);
        for(int i = leafTreeStart; i< leafTreeStart +N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for(int i=0; i<M+X; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // b번째 수를 c로 업데이트
            if(a==1) {
                changeValue((int)(leafTreeStart+b-1), c);
            }
            // b~c 구간합 출력
            else if(a==2) {
                int s = (int) (leafTreeStart + b - 1);
                int e =(int) (leafTreeStart + c - 1);
                System.out.println(getSum(s,e));
            }
        }
    }

    static int getK(int n) {
        int k = 0;
        int value = 1; // 2^0
        while(value < n) {
            value *= 2;
            k++;
        }
        return k;
    }

    static void setTree(int i) {
        while(i > 1) {
            tree[i/2] += tree[i];
            i--;
        }
    }

    static void changeValue(int index, long changeVal) {
        long diff = changeVal - tree[index];
        while(index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

    static long getSum(int s, int e) {
        long partSum = 0;
        while(s <= e) {
            if(s%2 == 1) {
                partSum += tree[s];
            }
            if(e%2 == 0) {
                partSum += tree[e];
            }

            s = (s+1) / 2;
            e = (e-1) / 2;
        }
        return partSum;
    }
}
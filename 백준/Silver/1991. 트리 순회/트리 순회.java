import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new int[26][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.') {
                tree[node][0] = -1;
            }
            else {
                tree[node][0] = left - 'A';
            }

            if(right == '.') {
                tree[node][1] = -1;
            }
            else {
                tree[node][1] = right - 'A';
            }
        }

        // 전위순회 -> 중위순회 -> 후위순회
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    static void preOrder(int now) {
        if(now == -1) {
            return;
        }
        System.out.print((char)(now + 'A')); // 현재
        preOrder(tree[now][0]); // 왼쪽
        preOrder(tree[now][1]); // 오른쪽
    }

    static void inOrder(int now) {
        if(now == -1) {
            return;
        }
        inOrder(tree[now][0]); // 왼쪽
        System.out.print((char)(now + 'A')); // 현재
        inOrder(tree[now][1]); // 오른쪽
    }

    static void postOrder(int now) {
        if(now == -1) {
            return;
        }
        postOrder(tree[now][0]); // 왼쪽
        postOrder(tree[now][1]); // 오른쪽
        System.out.print((char)(now + 'A')); // 현재
    }

}
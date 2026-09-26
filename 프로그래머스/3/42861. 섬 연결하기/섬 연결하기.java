import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // union-find 틀 만들기
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        // costs 배열을 비용 기준으로 오름차 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            } 
        });
        
        // 정렬된 순서대로 하나씩 돌면서 두 섬을 확인하고 
        // 이미 연결되었으면 ㅇㅋ
        // 아니면 union으로 연결하고 비용 추가하기
        for(int[] cost : costs) {
            int a = find(cost[0]);
            int b = find(cost[1]);
            
            if(a == b) continue;
            union(a,b);
            answer += cost[2];
        }
         
        // 답 반환
        return answer;
    }
    
    public int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return find(parent[x]);
    }
    
    public void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if(A != B) {
            parent[B] = A;
        }
    }
}
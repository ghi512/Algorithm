import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        prime = new boolean[n+1];
        getPrime();
        
        StringBuilder sb = new StringBuilder();

        for(int i=m; i<=n; i++) {
            if(!prime[i])
                sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
    public static void getPrime() {
        // true : 소수 아님, false : 소수
        prime[0] = prime[1] = true;
        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) // 이미 체크된 배열이면 다음 반복문으로 스킵
                continue;
            for(int j=i*i; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}
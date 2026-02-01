import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for(int k=0; k<S.length(); k++) {
                char ch = S.charAt(k);
                for(int j=0; j<R; j++) {
                    sb.append(ch);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
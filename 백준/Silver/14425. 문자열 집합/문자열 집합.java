import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int answer = 0;

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }

        String s;
        for(int i=0; i<m; i++) {
            s = br.readLine();
            if(set.contains(s)) answer++;
        }

        System.out.println(answer);
    }
}

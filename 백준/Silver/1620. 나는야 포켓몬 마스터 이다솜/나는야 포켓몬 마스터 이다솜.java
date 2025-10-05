import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] b = br.readLine().split(" ");
        int n = Integer.parseInt(b[0]); // 포켓몬의 개수
        int m = Integer.parseInt(b[1]); // 테케 수

        Map<Integer, String> numToName = new HashMap<>();
        Map<String, Integer> NameToNum = new HashMap<>();
        for(int i=1; i<=n; i++) {
            String name = br.readLine();
            numToName.put(i, name);
            NameToNum.put(name, i);
        }

        for(int i=0; i<m; i++) {
            String input = br.readLine();
            if(Character.isDigit(input.charAt(0))) {
                sb.append(numToName.get(Integer.parseInt(input))).append('\n');
            } else {
                sb.append(NameToNum.get(input)).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}

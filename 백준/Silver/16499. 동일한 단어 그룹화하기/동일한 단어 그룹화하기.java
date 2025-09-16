import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;

        HashSet<String> set = new HashSet<>();
        String s;

        for(int i=0; i<n; i++) {
            String[] list = sc.nextLine().split("");
            Arrays.sort(list);
            s = Arrays.toString(list);

            if(!set.contains(s)) {
                set.add(s);
                count++;
            }
        }

        System.out.println(count);
    }
}


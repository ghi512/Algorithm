import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        PriorityQueue<Integer> presentBoxes = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> childrenWish = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> childrenWish = new ArrayList<>();

        for(int i=0; i<N; i++) {
            presentBoxes.offer(sc.nextInt());
        }
        for(int i=0; i<M; i++) {
            childrenWish.add(sc.nextInt());
        }

        int answer = 1;
        for(int i=0; i<childrenWish.size(); i++) {
            int present = presentBoxes.poll();
            int wish = childrenWish.get(i);
            if(wish > present) {
                answer = 0;
                break;
            }
            else if (present > wish){
                presentBoxes.offer(present - wish);
            }
        }

        System.out.println(answer);
    }
}

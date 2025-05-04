import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 1. 판매자-추천인 정보를 담을 해시맵 생성 (parent)
        HashMap<String, String> parent = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i], referral[i]);
        }
        
        // 2. 판매자별 수익 합계를 담을 해시맵 생성 (total)
        HashMap<String, Integer> total = new HashMap<>();
        
        // 3. seller, amount 돌면서 수익 계산 (10% 제함)
        for(int i=0; i<seller.length; i++){
            String curName = seller[i];
            int money = amount[i] * 100;
            while(money>0 && !curName.equals("-")){
                total.put(curName, total.getOrDefault(curName, 0) + money - (money/10));
                curName = parent.get(curName);
                money /= 10;
            }
        }
         
        // 4. 모든 판매자의 수익 합계 저장
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}
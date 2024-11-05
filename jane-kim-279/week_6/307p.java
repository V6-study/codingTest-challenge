import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {     
        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        HashMap<String, Integer> sales = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            String current_seller = seller[i];
            int sale = amount[i] * 100;
            while (sale > 0 && !current_seller.equals("-")) {
                sales.put(current_seller, sales.getOrDefault(current_seller, 0) + sale - sale / 10);
                current_seller = parent.get(current_seller);
                sale = sale / 10;
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sales.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}

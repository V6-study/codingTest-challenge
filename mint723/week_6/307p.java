// https://school.programmers.co.kr/learn/courses/30/lessons/77486
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // enroll 판매원의 이름 (민호 이름 포함 x)
        // referral 각 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름
        // seller 판매량 집계 데이터의 판매원 이름
        // amount 판매 수량
        int[] answer = new int[enroll.length];
        
        Map<String, String> parents = new HashMap<>(); // 부모 정보
        Map<String, Integer> benefits = new HashMap<>(); // 현재 이익
        
        for(int i=0; i<enroll.length; i++){
            parents.put(enroll[i], referral[i]); // 구성원별 부모 할당
        }
        
        for(int i=0; i<seller.length; i++){
            int price = amount[i] * 100;
            int afterCalc = price;
            String currentSeller = seller[i];
            
            while(afterCalc > 0 && !currentSeller.equals("-")){ // 현재 판매원의 부모가 더 이상 존재하지 않을 때 까지
                int toParent = afterCalc / 10; // 부모에게 줄 10%
                int toSelf = afterCalc - toParent; // 현재 판매원이 갖는 90%
                
                benefits.put(currentSeller, benefits.getOrDefault(currentSeller, 0) + toSelf);
                
                currentSeller = parents.get(currentSeller);
                afterCalc = toParent;
            }
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = benefits.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}

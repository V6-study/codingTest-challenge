import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        // 이름으로 인덱스를 빠르게 찾기 위한 map 만들고 그 안에 값 담기.
        HashMap<String, Integer> idx = new HashMap<>(); // key: 판매원 이름, value: 인덱스
        HashMap<String, String> ref = new HashMap<>(); // key: 판매원 이름, value: 추천인 이름
        for(int i = 0; i<enroll.length; i++){
            idx.put(enroll[i], i);
            ref.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i<seller.length; i++){
            int a = amount[i]*100;
            String s = seller[i];
            while(true){
                int r = a / 10; // 추천인에게 줘야하는 금액
                answer[idx.get(s)] += a - r; // 가질 수 있는 금액
                // 다음 loop를 위해 값 변경
                s = ref.get(s);
                a = r; 
                // 가장 상위 판매원이거나, 이익이 0이되면 break
                if("-".equals(s) || a == 0){ break; }
            }
        }
        return answer;
    }
}

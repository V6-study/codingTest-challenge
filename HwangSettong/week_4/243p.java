// https://school.programmers.co.kr/learn/courses/30/lessons/131127
import java.util.*;
class Solution {
    public int getSum(Map<String, Integer> data) {
        return data.values().stream().reduce(0, Integer::sum);
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i< want.length; i++){
            map.put(want[i], Integer.valueOf(number[i]));
        }
        for(int i = 0; i < discount.length; i++){
            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i])-1);
            }
            if (i > 10) {
                map.put(discount[i-11], map.get(discount[i-11])+1);
            }
            if(getSum(map) == 0){
                return i+1;
            }
            
        }
        return 0;
    }
}

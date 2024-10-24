import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length-10; i++) {
            HashMap<String, Integer> newMap = new HashMap<>();
            newMap.putAll(map);
            for (int j = i; j < i + 10; j++) {
                String product = discount[j];
                
                if (newMap.containsKey(product) && newMap.get(product) > 0) {
                    newMap.put(product, newMap.get(product) - 1);
                }
            }
            
            boolean flag = true;
            for (String key : newMap.keySet()) {
                if (newMap.get(key) != 0) flag = false;
            }
            if (flag) answer ++;
        }
        
        return answer;
    }
}

import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        List<Integer> sortedValues = new ArrayList<>(map.values());
        Collections.sort(sortedValues,Collections.reverseOrder());
        int sum = 0;
        int type = 0;
        
        for(int i : sortedValues){
            sum += i;
            type++;
            if(sum >= k){
                break;
            }
        }
        return type;
    }
}

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : tangerine){
            map.put(n, map.getOrDefault(n, 0) +1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int n : map.values()){
            list.add(n);
        }
        
        list.sort((o1, o2) -> o2-o1);
        
        for(int n : list){
            if(k > 0){
                answer++;
                k-=n;
            }else
                return answer;
        }
        
        return answer;
    }
}

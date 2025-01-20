//https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=java
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> counts = new HashMap<>(); //key:귤크기, value:개수
        for(int t : tangerine){
            counts.put(t, counts.getOrDefault(t, 0)+1);
        }
        
        // keySet을 개수 내림차순으로 정렬
        int[] keySet = counts.keySet().stream().sorted((o1, o2) -> counts.get(o2)-counts.get(o1)).mapToInt(i->i).toArray();
        
        int answer = 0;
        for(int key: keySet){
            k-=counts.get(key);
            answer++;
            if(k <= 0) break;
        }
        return answer;
    }
}

// 프로그래머스: 귤 고르기
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        Collections.sort(counts, Comparator.reverseOrder());

        int answer = 0;
        for (int count : counts) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}

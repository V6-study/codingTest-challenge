import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();

        Map<String, Integer> gemCount = new HashMap<>();
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (right < gems.length) {
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);
            right++;

            while (gemCount.size() == totalTypes) {
                if (right - left < minLen) {
                    minLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                if (gemCount.get(gems[left]) == 0) {
                    gemCount.remove(gems[left]);
                }
                left++;
            }
        }
        
        return answer;
    }
}

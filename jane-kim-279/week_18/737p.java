import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> all = new HashSet<>();
        for (String gem : gems) {
            all.add(gem);
        }

        int[] answer = {1, gems.length};
        int left = 0, right = 0;
        HashSet<String> buy = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
      
        while (right < gems.length) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            buy.add(gems[right]);
            
            // l포인터 증가
            while (left < right && map.get(gems[left]) > 1) {
                map.put(gems[left], map.get(gems[left]) - 1);
                left++;
            }

            // 종료조건
            if (all.size() == buy.size()) {
                if ((right - left < answer[1] - answer[0]) || (right - left == answer[1] - answer[0] && left + 1 < answer[0])) {
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
            }

            // r포인터 증가
            right++;
        }
        return answer;
    }
}

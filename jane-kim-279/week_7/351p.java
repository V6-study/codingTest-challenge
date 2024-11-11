import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int cnt = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        answer = set.size();
        if (set.size() >= cnt) {
            answer = cnt;
        } else {
            answer = set.size();
        }
        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }

        int idx = 5, equal = 0, zero = 0;
        for (int num : lottos) {
            if (num == 0) {
                zero++;
            } else if (winSet.contains(num)) {
                equal++;
            }
        }

        int max = equal + zero < 2 ? 6 : 7 - equal - zero;
        int min  = equal < 2 ? 6 : 7 - equal;
        int[] answer = new int[]{max, min};
        return answer;
    }
}

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();

        for (int t : topping) {
            a.put(t, a.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            b.put(t, b.getOrDefault(t, 0) + 1);
            a.put(t, a.getOrDefault(t, 0) - 1);

            if (a.get(t) <= 0) {
                a.remove(t);
            }

            if (a.keySet().size() == b.keySet().size()) {
                answer++;
            }
        }

        return answer;
    }
}

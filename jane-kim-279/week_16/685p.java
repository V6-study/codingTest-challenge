import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;

        for (int amount : d) {
            if (budget < amount) {
                break;
            }
            budget -= amount;
            count++;
        }
        return budget >= 0 ? count : count - 1;
    }
}

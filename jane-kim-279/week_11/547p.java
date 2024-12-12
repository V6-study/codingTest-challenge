import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int tc = 0; tc < commands.length; tc++) {
            int i = commands[tc][0];
            int j = commands[tc][1];
            int k = commands[tc][2];

            int[] copy = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(copy);
            answer[tc] = copy[k - 1];
        }
        return answer;
    }
}

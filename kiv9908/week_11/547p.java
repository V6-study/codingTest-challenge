import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            List<Integer> sublist = new ArrayList<>();

            for(int j = commands[i][0]-1; j < commands[i][1]; j++) {
                sublist.add(array[j]);
            }
            Collections.sort(sublist);
            answer.add(sublist.get(commands[i][2]-1));

        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
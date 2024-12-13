import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands){
            List<Integer> cut = new ArrayList<>();
            int i = command[0]-1;
            int j = command[1]-1;
            int k = command[2]-1;
            for(int start = i ; start <= j;start++){
                cut.add(array[start]); 
            }
            Collections.sort(cut);
            answer[idx]=cut.get(k);
            idx++;
            
        }
        return answer;
    }
}
// https://school.programmers.co.kr/learn/courses/30/lessons/42748
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
            List<Integer> subList = list.subList(commands[i][0]-1, commands[i][1]);
            Collections.sort(subList);
            
            answer[i] = subList.get(commands[i][2]-1);
        }
        
        return answer;
    }
}

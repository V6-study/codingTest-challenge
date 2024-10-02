import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] peoples = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] scores = new int[peoples.length];
        
        int max = 0;
        
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<peoples.length; j++){
                if(answers[i] == peoples[j][i%peoples[j].length]){
                    scores[j] += 1;
                    if(scores[j]>max) max=scores[j];
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<scores.length; i++){
            if(scores[i] == max) list.add(i+1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}

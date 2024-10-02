import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=numbers.length-1; j>i; j--){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = set.stream().mapToInt(i->i).toArray();
        
        Arrays.sort(answer);
        return answer;
    }
}

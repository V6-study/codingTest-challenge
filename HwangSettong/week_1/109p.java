import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Set<Integer> set  = new TreeSet<>(Collections.reverseOrder());
        for(int a : arr){
            set.add(a);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}

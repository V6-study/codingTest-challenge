import java.util.*;
class Solution {
    public boolean solution(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : arr){
            if(map.getOrDefault(n, -1) != -1){
                return true;
            }else if(n <= target){
                map.put(target-n, n);
            }
        }
        return false;
    }
}

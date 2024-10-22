import java.util.HashSet;

public class Solution {
    private static boolean solution(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : arr){
            if (set.contains(target-i)){
                return true;
            }
            set.add(i); // 1+3 = 3+1 이므로 어떤 값을 기준으로 target을 찾아도 상관없음.
        }
        return false;
    }

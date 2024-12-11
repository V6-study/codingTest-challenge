import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr,Collections.reverseOrder());
        for(String s : arr){
            sb.append(s);
        }
        return Long.parseLong(sb.toString());
    }
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12933
import java.util.*;

class Solution {
    public long solution(long n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }
        return Long.parseLong(sb.toString());
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12933
import java.util.*;
class Solution {
    public long solution(long n) {
        String[] temp = String.valueOf(n).split("");
        Arrays.sort(temp, Collections.reverseOrder());
        return Long.parseLong(String.join("", temp));
    }
}

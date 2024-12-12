import java.util.*;

class Solution {
    public long solution(long n) {
        String[] digits = String.valueOf(n).split("");
        Arrays.sort(digits, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String dg : digits) {
            sb.append(dg);
        }
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}

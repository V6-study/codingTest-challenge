import java.util.*;

class Solution {
    static int zeroCnt = 0;
    static int cnt = 0;

    public int[] solution(String s) {
        while (!s.equals("1")) {
            cnt++;
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeroCnt++;
                else len++;
            }
            s = Integer.toBinaryString(len);
        }
        int[] answer = {cnt, zeroCnt};
        return answer;
    }
}

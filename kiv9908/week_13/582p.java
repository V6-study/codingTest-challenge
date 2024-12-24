import java.util.*;

class Solution {
    public int[] solution(String s) {
        int changeCnt=0, zeroCnt=0;
        
        while(!s.equals("1")){
            int oldLength = s.length();
            s = s.replaceAll("0","");
            int newLength = s.length();
            zeroCnt += oldLength - newLength;
            s = Integer.toBinaryString(newLength);
            changeCnt++;
        }

        return new int[]{changeCnt, zeroCnt};
    }
}
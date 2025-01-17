// https://school.programmers.co.kr/learn/courses/30/lessons/12982
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < d.length; i++) {
            if(sum<=budget){
                sum+=d[i];
                answer++;
            }
        }
        answer = (sum<=budget)?answer:answer-1;
        return answer;
    }
}

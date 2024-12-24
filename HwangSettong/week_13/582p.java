// https://school.programmers.co.kr/learn/courses/30/lessons/70129
import java.util.*;

class Solution {
    String convert2(int x){
        StringBuilder sb = new StringBuilder();
        while(x > 0){
            sb.append(x%2);
            x /= 2;
        }
        return sb.toString();
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2]; // answer[0]은 횟수 [1]은 개수
        int except0; // 0을 제외한 문자열 길이
        while(!s.equals("1")){
            answer[0]++;
            except0 = s.replace("0", "").length();
            answer[1] += s.length()-except0;
            s = convert2(except0);
        }
        
        return answer;
    }
}

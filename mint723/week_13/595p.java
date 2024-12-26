// https://school.programmers.co.kr/learn/courses/30/lessons/12980
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n!=0){
            if(n%2==0){
                n/=2;
            }else{
                n-=1;
                answer++;
            }   
        }
        return answer;
    }
}

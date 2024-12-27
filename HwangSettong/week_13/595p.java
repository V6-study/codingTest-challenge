//https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class Solution {
    public int solution(int n) {
        int answer = 1;
        while(n != 1){
            if(n%2 == 0){
                n /= 2;
            }else{
                answer++;
                n --;
            }
        }
        return answer;
    }
}

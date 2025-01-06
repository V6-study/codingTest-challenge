// https://school.programmers.co.kr/learn/courses/30/lessons/12945
class Solution {
    public int solution(int n) {
        int f1 = 1;
        int f2 = 1;
        int answer = 1;
        for(int i = 3; i<=n ; i++){
            answer = (f1+f2)%1234567;
            f1 = f2;
            f2 = answer;
        }
        return answer;
    }
}

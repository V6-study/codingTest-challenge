// https://school.programmers.co.kr/learn/courses/30/lessons/12900
class Solution {
    public int solution(int n) {
        if(n==1) return n;
        if(n==2) return n;
        int f1 = 1;
        int f2 = 2;
        int answer=0;
        for(int i=3; i<=n; i++){
            answer = (f1+f2)%1000000007;
            f1 = f2;
            f2 = answer;
        }
        return answer;
    }
}

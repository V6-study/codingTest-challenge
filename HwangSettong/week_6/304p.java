// https://school.programmers.co.kr/learn/courses/30/lessons/12985
class Solution
{
    public int solution(int n, int a, int b){
        int answer = 0; // 게임 라운드
        // 참가자 번호를 0 ~ n-1번으로 줘야 2로 나눴을 때 앞에서부터 둘 씩 같은 값을 갖게 됨. 
        a--;
        b--;
        // loop 돌면서 a와 b 2로 나눠주기.
        while(true){
            answer ++; // 라운드 +1
            a /= 2;
            b /= 2;
            if(a==b){ // 2로 나눈 a와 b의 값이 같으면 만난 것.
                break;
            }
        }
        return answer;
    }
}

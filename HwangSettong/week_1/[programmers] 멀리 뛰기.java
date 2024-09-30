// https://school.programmers.co.kr/learn/courses/30/lessons/12914?language=java#
class Solution {
    public long solution(int n) {
        int pre =1 , cur=1;
        int temp;
        
        for(int i = 2; i <= n; i++){
            temp = pre;
            pre = cur;
            cur = (cur + temp) % 1234567;
        }
        
        return cur;
    }
}

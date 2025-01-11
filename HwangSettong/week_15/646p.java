// https://school.programmers.co.kr/learn/courses/30/lessons/42897#
class Solution {
    public int solution(int[] money) {
        int[][] dp1 = new int[2][money.length]; // 첫 번째 집을 털 때 {{현재 집 털 때}, {현재 집 안 털 때}}
        int[][] dp2 = new int[2][money.length]; // 첫 번째 집을 안 털 때 {{현재 집 털 때}, {현재 집 안 털 때}}
        dp1[0][0] = money[0];
        dp2[1][0] = money[1];
        dp1[1][1] = money[0];
        dp2[0][1] = money[1];
        
        for(int i=2; i<money.length; i++){
            dp1[0][i] = money[i] + Math.max(dp1[0][i-2], dp1[1][i-1]); // 현재 집을 턴다
            dp1[1][i] = Math.max(dp1[0][i-1], dp1[1][i-1]); // 현재 집을 안 턴다
            
            dp2[0][i] = money[i] + Math.max(dp2[0][i-2], dp2[1][i-1]); // 현재 집을 턴다
            dp2[1][i] = Math.max(dp2[0][i-1], dp2[1][i-1]); // 현재 집을 안 턴다
        }
        
        return Math.max(dp1[1][money.length-1], dp2[0][money.length-1]);
    }
}

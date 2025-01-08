// https://school.programmers.co.kr/learn/courses/30/lessons/43105
import java.lang.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j <= i; j++){
                triangle[i][j] += Math.max(
                    triangle[i-1][Math.max(j-1, 0)], 
                    triangle[i-1][Math.min(j, i-1)]);
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
    
}

// https://school.programmers.co.kr/learn/courses/30/lessons/43105
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 양 끝값 계산
        for(int i=1; i<triangle.length; i++){
            int[] arr = triangle[i-1];
            triangle[i][0] += arr[0];
            triangle[i][triangle[i].length-1] += arr[arr.length-1];
        }
        
        // 상위 노드 중 큰 값 더하기
        for(int i=2; i<triangle.length; i++){
            for(int j=1; j<triangle[i].length-1; j++){
                int max = Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                triangle[i][j] += max;
            }
        }
        
        // 마지막 배열의 최댓값 리턴
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}

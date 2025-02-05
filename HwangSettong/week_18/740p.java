//https://school.programmers.co.kr/learn/courses/30/lessons/92344
import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int row = board.length, col = board[0].length;
        int[][] sum = new int[row][col]; 
        // 누적합 계산
        for(int[] s: skill){
            int type=s[0]==1?-1:1, r1=s[1], c1=s[2], r2=s[3], c2=s[4], degree=s[5];
            sum[r1][c1] += type*degree;
            if(c2+1<col) sum[r1][c2+1] += (-type)*degree;
            if(r2+1<row) sum[r2+1][c1] += (-type)*degree;
            if(r2+1<row&&c2+1<col) sum[r2+1][c2+1] += type*degree;
        }
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(c>0) sum[r][c] += sum[r][c-1];
            }
        }
        for(int c=0; c<col; c++){
            for(int r=0; r<row; r++){
                if(r>0) sum[r][c] += sum[r-1][c];
            }
        }
        
        // board랑 합산
        int answer = 0;
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(board[r][c] > -sum[r][c]) answer++;
            }
        }
        return answer;
    }
}

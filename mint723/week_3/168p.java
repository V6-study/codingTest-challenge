// https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves){
            int idx = move-1;
            for(int i=0; i<board.length; i++){
                if(board[i][idx] != 0){
                    int doll = board[i][idx];
                    if(!stack.isEmpty() && stack.peek() == doll){
                        board[i][idx] = 0;
                        stack.pop();
                        answer+=2;
                        break;
                    }else{
                        stack.push(doll);
                        board[i][idx] = 0;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

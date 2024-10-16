// https://school.programmers.co.kr/learn/courses/30/lessons/64061
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        HashMap<Integer,Stack<Integer>> stacks = new HashMap<Integer,Stack<Integer>>();
        Stack<Integer> stack;
        for(int key=0; key<board.length; key++){
            stack = new Stack<Integer>();
            for(int i = board.length - 1; i >= 0 ; i--){
                if(board[i][key] == 0){break;}
                stack.push(board[i][key]);
            }
            stacks.put(key+1, stack);
        }
        
        stack = new Stack<Integer>();
        int answer = 0, temp;
        for(int m : moves){
            if(stacks.get(m).isEmpty()){
                continue;
            }
            temp = stacks.get(m).pop();
            if(!stack.isEmpty() && stack.peek() == temp){
                stack.pop();
                answer+=2;
            }else{
                stack.push(temp);
            }
        }
        return answer;
    }
}

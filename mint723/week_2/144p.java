// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char idx = s.charAt(i);
            
            if(idx == '('){
                stack.push(')');
            }else{
                if(!stack.isEmpty() && idx == stack.peek()) stack.pop();
                else return false;
            }
        }
        
        return stack.isEmpty();
    }
}

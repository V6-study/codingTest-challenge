// https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i) + s.substring(0,i);
            if(isValid(str))
                answer++;
        }
        return answer;
    }
    
    boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '['){
                stack.push(']');
            }else if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else{
                if(!stack.isEmpty() && stack.peek() == c)
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.size()==0;
    }
}

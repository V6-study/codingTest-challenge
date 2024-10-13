// https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || stack.peek()!=c){
                stack.add(c);
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty()?1:0;
    }
}

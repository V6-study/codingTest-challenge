// https://school.programmers.co.kr/learn/courses/30/lessons/42883

import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<number.length(); i++){
            int num = number.charAt(i) - '0';
            
            while(!stack.isEmpty() && stack.peek() < num && count != k){
                stack.pop();
                count++;
            }
            
            stack.push(num);
        }
        while(stack.size() != number.length() - k){
            stack.pop();
        }
        
        return stack.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}

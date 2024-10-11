import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int idx = 0, cnt = 0, answer=0;
        if(s.length()%2!=0){return 0;}
        loop1:while(cnt < s.length()){
            answer = 0;
            for(int i = 1; i<= s.length(); i++){
                if(s.charAt(idx)==')'||s.charAt(idx)=='}'||s.charAt(idx)==']'){
                    if(!stack.isEmpty() && (stack.peek()+2==s.charAt(idx)||stack.peek()+1==s.charAt(idx))){
                        stack.pop();
                    }else{ // 회전
                        cnt+=i;
                        idx = (idx+1)%s.length();
                        stack.clear();
                        break;
                    }
                }else{
                    stack.push(s.charAt(idx));
                }
                if(stack.isEmpty()) {
                    answer++;
                    if(i==s.length()){
                        break loop1;
                    }
                }
                idx = (idx+1)%s.length();
            }  
        }
        
        return answer;
    }
}

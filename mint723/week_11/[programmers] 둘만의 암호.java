// https://school.programmers.co.kr/learn/courses/30/lessons/155652
import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {        
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            for(int i=0; i<index; i++){
                c++;
                boolean flag = false;
                while(!flag){
                    if(c>'z'){
                        c-=26;
                    }
                    if(skip.contains(String.valueOf(c))){
                        c++;
                    }else{
                        flag = true;
                    }
                }
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}

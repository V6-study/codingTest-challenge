// https://school.programmers.co.kr/learn/courses/30/lessons/12930#
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(String str : s.split(" ",-1)){
            char[] carr = str.toLowerCase().toCharArray();
            for(int i=0; i<carr.length; i++){
                if(i%2 == 0){
                    sb.append(Character.toUpperCase(carr[i]));
                }else{
                    sb.append(Character.toLowerCase(carr[i]));
                }
            }
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.toString().length()-1);
        return sb.toString();
    }
}

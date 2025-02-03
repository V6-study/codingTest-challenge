https://school.programmers.co.kr/learn/courses/30/lessons/77886#
import java.util.*;
class Solution {
    String changeX(StringBuilder s){
        StringBuilder zzo = new StringBuilder(); // 110집합
        // s에서 110 제거하고 zzo에 추가
        int i = 0;
        int zeroIdx = -1; // 마지막 0 인덱스 찾기
        while(i < s.length()-2){
            if(s.charAt(i)=='1'&&s.charAt(i+1)=='1'&&s.charAt(i+2)=='0'){
                zzo.append("110");
                s.replace(i, i+3, "");
                if(i > 1) i-= 2;
                else i = 0;
            }else{
                if(s.charAt(i)=='0') zeroIdx = i;
                i++;
            }
        }
        if(i<s.length() && s.charAt(i)=='0') zeroIdx = i;
        if(i+1<s.length() && s.charAt(i+1)=='0') zeroIdx = i+1;
        
        
        // 110 집합 마지막 0 다음 위치에 넣어주기, 만약 0이 없으면 맨 앞에 넣어주기
        if(s.length() == 0) return zzo.toString();
        if(zeroIdx == s.length()-1) s.append(zzo);
        else s.insert(zeroIdx+1, zzo);        
        
        return s.toString();
    }
    
    
    public String[] solution(String[] s) {
        String[] answer =  new String[s.length];
        for(int i = 0; i<s.length; i++){
            answer[i] = changeX(new StringBuilder(s[i]));   
        }
        return answer;
    }
}

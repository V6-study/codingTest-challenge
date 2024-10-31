// https://school.programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;
class Solution {
    public List<String> solution(String[] record) {
        
        Map<String, String> user = new HashMap<>();
        
        for (int i = 0; i<record.length; i++){
            String[] info = record[i].split(" ");
            if(!info[0].equals("Leave")){
                user.put(info[1],info[2]);
            }
            
        }
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i<record.length; i++){
            String[] info = record[i].split(" ");
            if(info[0].equals("Enter")){
                answer.add(user.get(info[1])+"님이 들어왔습니다.");
                }
            else if(info[0].equals("Leave")){
                answer.add(user.get(info[1])+"님이 나갔습니다.");
            }
        }
        
        
        return answer;
    }
}
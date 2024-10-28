// https://school.programmers.co.kr/learn/courses/30/lessons/42888
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<String, String>(); // <유저아이디, 닉네임>
        int cnt = 0; // 최종적으로 보이게 될 메시지 수
        for(String re : record){
            String[] temp = re.split(" ");
            // 유저아이디와 닉네임이 있으면 user에 put
            if(! "Leave".equals(temp[0])){ 
                user.put(temp[1], temp[2]);  
            }
            // 닉네임 변경 기록이 아니면 cnt +1 함
            if(! "Change".equals(temp[0])){
                cnt++;    
            }
        }
        
        
        String[] answer = new String[cnt]; // answer 배열 생성
        int j = 0; // answer의 index
        for(String re : record){
            String[] temp = re.split(" ");
            if("Leave".equals(temp[0])){ // Leave일 때 answer 값 추가
                answer[j++] = user.get(temp[1]) + "님이 나갔습니다.";
            } else if ("Enter".equals(temp[0])){ // Enter 때 answer 값 추가
                answer[j++] = user.get(temp[1]) + "님이 들어왔습니다.";
            }
        }
        return answer;
    }
}

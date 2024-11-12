https://school.programmers.co.kr/learn/courses/30/lessons/340213
import java.util.*;
class Solution {
    // 자동 건너뛰기 적용
    int[] op_jump(String pos, String op_start, String op_end){
        if(pos.compareTo(op_start)>=0 && op_end.compareTo(pos) >= 0){
            pos = op_end;
        }
        return convert(pos);
    }
    
    // 00:00 ~ video_len 범위 안으로 조정
    int[] checkRange(int[] pos, String video_len){
        if(pos[0] < 0){
            return new int[] {0,0};
        }
        if(convert(pos).compareTo(video_len) > 0){
            return convert(video_len);
        }
        return pos;
    }
    
    
    // 데이터 형식 바꾸기
    String convert(int[] time){
        return (time[0]<10? "0":"")+time[0]+":"+(time[1]<10? "0":"")+time[1];
    }
    int[] convert(String time){
        return Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
    }
    

    

    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 오프닝 건너뛰기
        int[] curPos = op_jump(pos, op_start, op_end);
        
        // 사용자 명령어 실행
        for(String c : commands){
            if(c.equals("next")){ // 10초 후로 이동
                if(curPos[1] + 10 >= 60){ 
                    curPos[0]++;
                }
                curPos[1] = (curPos[1] + 10) % 60; 
            }else{ // 10초 전으로 이동
                if(curPos[1] - 10 < 0){
                    curPos[0]--;
                    curPos[1] += 50;
                }else{
                    curPos[1]-= 10;
                }
            }
            // 비디오 범위와 오프닝 건너뛰기 적용
            curPos = checkRange(curPos, video_len);
            curPos = op_jump(convert(curPos), op_start, op_end);
        }
        
       
        return convert(curPos);
    }
}

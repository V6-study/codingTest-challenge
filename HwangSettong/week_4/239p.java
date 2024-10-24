//https://school.programmers.co.kr/learn/courses/30/lessons/42576
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String com : completion){
            if(map.get(com) == null){
                map.put(com, 1);
            }else{
                map.put(com, map.get(com)+1);
            }
        }
        for(String par: participant){
            if(map.get(par) != null){
                if(map.get(par) == 1){
                    map.remove(par);
                }else{
                    map.put(par, map.get(par)-1);
                }
            }else{
                return par;
            }
        }
        return "";
    }
}

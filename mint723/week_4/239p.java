// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String name : participant){
            if(map.containsKey(name)){
                map.put(name, map.get(name)+1);
            }else{
                map.put(name, 1);
            }
        }
        
        for(String name : completion){
            map.put(name, map.get(name)-1);
        }
        
        List<String> names = new ArrayList<>(map.keySet());
        
        for(String name : names){
            if(map.get(name) != 0)
                return name;
        }
        
        return "";
    }
}

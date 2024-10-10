// https://school.programmers.co.kr/learn/courses/30/lessons/160586

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            char[] arr = keymap[i].toCharArray();
            for(int j=0; j<arr.length; j++){
                if(map.containsKey(arr[j])){
                    if(map.get(arr[j])>j+1)
                        map.put(arr[j],j+1);
                }else{
                    map.put(arr[j],j+1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            int count = 0;
            char[] arr = targets[i].toCharArray();
            for(int j=0; j<arr.length; j++){
                char c = arr[j];
                
                if(!map.containsKey(c)){
                    count = -1;
                    break;
                }

                count += map.get(c);
            }
            answer[i] = count;
        }
        
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/64065
import java.util.*;

class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> maxValue = new HashMap<>();
        Set<String> set = new HashSet<>();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                sb.append(s.charAt(i));
            }else{
                if(sb.length()!=0){
                    if(!map.containsKey(sb.toString())){
                        map.put(sb.toString(), 1);
                    }else{
                        map.put(sb.toString(), map.get(sb.toString())+1);
                    }
                    set.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }
        
        set.forEach(num -> maxValue.put(map.get(num), num));
        q.addAll(map.values());        
        
        int[] answer = new int[set.size()];
        int count = 0;
        while(!q.isEmpty()){
            answer[count] = Integer.parseInt(maxValue.get(q.poll()));
            count++;
        }
        return answer;
    }
}

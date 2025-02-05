//https://school.programmers.co.kr/learn/courses/30/lessons/67258#
import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        for(String gem: gems) set.add(gem);
        // 보석 종류가 1개면 return
        if(set.size() == 1) return new int[] {1,1}; 

        int[] answer = {1, gems.length}; // {start, end}
        HashMap<String, Integer> cnt = new HashMap<>(); // key는 보석, value는 수.
        // start와 end 포인터 사용
        int start = 0;
        for(int end = 0; end<gems.length; end++){
            cnt.put(gems[end], cnt.getOrDefault(gems[end], 0)+1);
            while(set.size() == cnt.size() && start < end){
                if(end-start < answer[1]-answer[0]){
                    answer[0]=start+1;
                    answer[1]=end+1;
                }
                
                if(cnt.get(gems[start]) == 1) cnt.remove(gems[start]);
                else cnt.put(gems[start], cnt.get(gems[start])-1);
                start++;
            }
        }
        
        return answer;
    }
}

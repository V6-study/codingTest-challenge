// https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : priorities){
            q.add(i);
        }
        
        while(!q.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(!q.isEmpty() && priorities[i] == q.peek()){
                    q.poll();
                    answer++;
                    if(i == location) return answer;
                }
            }
        }
        
        return answer;
    }
}

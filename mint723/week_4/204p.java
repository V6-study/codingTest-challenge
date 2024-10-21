// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int completedDate = (int)Math.ceil((100 - progresses[i]) / (speeds[i]*1.0));
            q.offer(completedDate);
        }
        
        while(!q.isEmpty()){
            int cnt = 1;
            int num = q.poll();
            
            while(!q.isEmpty() && q.peek() <= num){
                q.poll();
                cnt++;
            }
            list.add(cnt);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}

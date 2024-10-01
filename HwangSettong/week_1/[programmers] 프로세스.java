// https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java#
import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] priorities, int location) {  
        Queue<Integer> que = new LinkedList<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities){
            que.offer(p);
            max.offer(p);
        }
        int answer = 0;
        while(que.size()>0){
            if(max.peek() == que.peek()){
                answer++;
                if(location == 0){
                    return answer;
                }
                max.poll();
                que.poll();
            } else {
                que.offer(que.poll());
            }
            location = (location + que.size() - 1) % que.size();
        }
        
        return 0;
    }
}

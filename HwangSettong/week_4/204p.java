//https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=java
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Double> queue = new LinkedList<>();
        for(int i = 0; i < speeds.length; i++){
            double temp = Math.ceil((double)(100 - progresses[i])/speeds[i]);
            if(temp > (queue.peek()==null? 100 : queue.peek())){
                answer.add(queue.size());
                queue.clear();
            }
            queue.offer(temp);
            if(i == speeds.length -1){
                answer.add(queue.size());
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}

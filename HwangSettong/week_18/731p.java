// https://school.programmers.co.kr/learn/courses/30/lessons/118667
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i<queue1.length; i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        int answer = 0;
        while(sum1 != sum2){
            answer++;
            if(sum1 > sum2){
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            }
            else{
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
            }
            if(answer == 600000) return -1;
        }
        return answer;
    }
}

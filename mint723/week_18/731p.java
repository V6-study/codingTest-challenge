import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long q1sum = 0;
        long q2sum = 0;
        
        for(int i=0; i<queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            q1sum+=queue1[i];
            q2sum+=queue2[i];
        }
        
        while(q1sum != q2sum && !q1.isEmpty() && !q2.isEmpty()){
            if(answer > (queue1.length * 4) + (queue2.length * 4))
                break;
            
            if(q1sum>q2sum){
                int poll = q1.poll();
                q1sum -= poll;
                
                q2.offer(poll);
                q2sum += poll;
            }else{
                int poll = q2.poll();
                q2sum -= poll;
                
                q1.offer(poll);
                q1sum += poll;
            }
            answer++;
        }
        
        return q1sum!=q2sum?-1:answer;
    }
}

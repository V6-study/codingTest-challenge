
import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : d){
            pq.add(num);
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            if(pq.peek() <= budget){
                budget -= pq.poll();
                cnt++;
            }else{
                pq.poll();
            }
        }
        return cnt;
    }
}
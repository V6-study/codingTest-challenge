// https://school.programmers.co.kr/learn/courses/30/lessons/131128
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        PriorityQueue<Character> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Character> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        for(char cx : X.toCharArray()){
            pq1.offer(cx);
        }
        
        for(char cy : Y.toCharArray()){
            pq2.offer(cy);
        }
        
        while(!pq1.isEmpty() && !pq2.isEmpty()){
            if(pq1.peek() > pq2.peek()){
                pq1.poll();
            }else if(pq1.peek() < pq2.peek()){
                pq2.poll();
            }else{
                pq1.poll();
                sb.append(pq2.poll());
            }
        }
        
        return sb.toString().equals("")?"-1":sb.toString().startsWith("0")?"0":sb.toString();
    }
}

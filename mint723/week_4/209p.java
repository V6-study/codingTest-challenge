// https://school.programmers.co.kr/learn/courses/30/lessons/159994

import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> word1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> word2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> q = new LinkedList<>(Arrays.asList(goal));
        
        int answer = 0;
        
        while(!q.isEmpty()){
            if(!word1.isEmpty() && word1.peek().equals(q.peek())){
                word1.poll();
                q.poll();
            }else if(!word2.isEmpty() && word2.peek().equals(q.peek())){
                q.poll();
                word2.poll();
            }else{
                break;
            }
        }
        
        if(q.isEmpty()) return "Yes";
        return "No";
    }
}

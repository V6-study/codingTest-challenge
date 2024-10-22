// https://school.programmers.co.kr/learn/courses/30/lessons/159994?language=java

import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Deque<String> q1 = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> q2 = new ArrayDeque<>(Arrays.asList(cards2));
        Deque<String> g = new ArrayDeque<>(Arrays.asList(goal));
        String answer = "Yes";
        
        while(!g.isEmpty()){
            
            if(!q1.isEmpty() && q1.peekFirst().equals(g.peekFirst())){
                q1.pollFirst();
                g.pollFirst();
                System.out.println(answer);
            }
            else if (!q2.isEmpty() && q2.peekFirst().equals(g.peekFirst())){
                q2.pollFirst();
                g.pollFirst();
            }
            else{
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}

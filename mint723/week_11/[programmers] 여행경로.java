// https://school.programmers.co.kr/learn/courses/30/lessons/43164
import java.util.*;

class Solution {
    List<String> answer;
    Map<String, PriorityQueue<String>> graph;
    
    public List solution(String[][] tickets) {        
        answer = new LinkedList<>();
        graph = new HashMap<>();
        
        for(String[] ticket: tickets){
            if(!graph.containsKey(ticket[0])){
                graph.put(ticket[0], new PriorityQueue<>());
                graph.get(ticket[0]).offer(ticket[1]);
            }else{
                graph.get(ticket[0]).offer(ticket[1]);
            }
        }
        
        dfs("ICN");
        
        return answer;
        
    }
    
    void dfs(String cur){
        PriorityQueue<String> pq = graph.get(cur);
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        answer.add(0, cur);
    }
}

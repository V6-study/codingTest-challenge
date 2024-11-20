// https://school.programmers.co.kr/learn/courses/30/lessons/49189
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        List<Integer>[] adjList = new List[n+1];
        
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] nodes : edge){
            // 양방향 연결
            adjList[nodes[0]].add(nodes[1]);
            adjList[nodes[1]].add(nodes[0]);
        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        Queue<Integer> q = new LinkedList<>(); // cost는 1로 동일하므로 그냥 큐로 선언
        q.offer(1);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(visited[cur])
                continue;
                
            visited[cur] = true;
            
            for(int next : adjList[cur]){
                if(dist[next] > dist[cur] + 1){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = Arrays.stream(dist).filter(i -> i != Integer.MAX_VALUE).max().getAsInt();
        
        return (int)Arrays.stream(dist).filter(i -> i == max).count();
    }
}

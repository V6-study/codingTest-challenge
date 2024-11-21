// https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<int[]>[] graph = new List[N+1];
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] info : road){
            int node1 = info[0];
            int node2 = info[1];
            int cost = info[2];
            
            graph[node1].add(new int[]{node2, cost});
            graph[node2].add(new int[]{node1, cost});
        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        pq.offer(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int dest = cur[0];
            int curCost = cur[1];
            
            if(visited[dest]){    
                continue;
            }
            
            visited[dest] = true;
            
            for(int[] info : graph[dest]){
                int next = info[0];
                int nextCost = info[1];
                if(dist[next] > curCost + nextCost){
                    dist[next] = curCost + nextCost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        return (int)Arrays.stream(dist).filter(i -> i<=K).count();
    }
}

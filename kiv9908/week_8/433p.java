import java.util.*;

class Solution {
    
    private static class Node{
        int dest;
        int cost;
        
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<Node>[] A = new ArrayList[N+1];
        for(int i = 1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<road.length; i++){
            A[road[i][0]].add(new Node(road[i][1],road[i][2]));
            A[road[i][1]].add(new Node(road[i][0],road[i][2]));
        }
        
        int[] time = new int[N+1];
        Arrays.fill(time, Integer.MAX_VALUE);
            
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost,o2.cost));
        q.offer(new Node(1,0));
        time[1] = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(time[now.dest] < now.cost){
                continue;
            }
            
            for(Node next : A[now.dest]){
                if(now.cost+next.cost < time[next.dest]){
                    time[next.dest] = now.cost+next.cost;
                    q.offer(new Node(next.dest,time[next.dest]));
                }
            }
        }
        for(int i = 1; i<N+1;i++){
            if(time[i] <= K) answer++;
        }

        return answer;
    }
}
// https://school.programmers.co.kr/learn/courses/30/lessons/42861?language=java

import java.util.*;

class Solution {
    
    private static int[] parent;
    
    private static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y){
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        parent = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            int node1 = costs[i][0];
            int node2 = costs[i][1];
            if(find(node1) != find(node2)){
                union(node1, node2);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
}

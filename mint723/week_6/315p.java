// https://school.programmers.co.kr/learn/courses/30/lessons/92343

import java.util.*;

class Solution {
    
    private static class Info{
        int node, sheep, wolf;
        Set<Integer> visited;
        
        public Info(int node, int sheep, int wolf, Set<Integer> visited){
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
    
    private static List<Integer>[] tree;
    
    private static void buildTree(int[] info, int[][] edges){
        tree = new ArrayList[info.length];
        for(int i=0; i<tree.length; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            tree[edge[0]].add(edge[1]);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        buildTree(info, edges);
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(0,1,0, new HashSet<>()));
        
        while(!q.isEmpty()){
            Info now = q.poll();
            answer = Math.max(answer, now.sheep);
            now.visited.addAll(tree[now.node]);
            
            for(int next : now.visited){
                Set<Integer> set = new HashSet<>(now.visited);
                set.remove(next);
                
                if(info[next] == 1){
                    if(now.sheep != now.wolf + 1){
                        q.offer(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                }else{
                    q.offer(new Info(next, now.sheep +  1, now.wolf, set));
                }
            }
        }
        return answer;
    }
}

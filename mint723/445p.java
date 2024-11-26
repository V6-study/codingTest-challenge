// https://school.programmers.co.kr/learn/courses/30/lessons/86971
import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int answer, N;
    
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n;
        graph = new List[n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int[] info = wires[i];
            graph[info[0]].add(info[1]);
            graph[info[1]].add(info[0]);
        }
        
        dfs(1);
        return answer;
    }
    
    int dfs(int idx){
        visited[idx] = true;
        int sum = 0;
        
        for(int next : graph[idx]){
            if(!visited[next]){
                int cnt = dfs(next); // 현재 서브트리의 노드 수
                answer = Math.min(answer, Math.abs(N - cnt * 2));  // 두 전력망의 노드 개수 차이
                sum += cnt; // 현재 노드의 자식 노드에서 반환된 노드 수 합산
            }
        }
        return sum + 1; // 현재 노드를 포함한 전체 서브트리의 노드 수 반환
    }
    
}

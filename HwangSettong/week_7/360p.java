import java.util.*;
class Solution {
    int[] parent; // 부모 노드 정보
    // root 찾기
    int findRoot(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = findRoot(parent[a]); // 경로 압축
    }
    
    // 두 집합 합치기
    void union(int a, int b){
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        parent[rootA] = rootB;
    }
    
    public int solution(int n, int[][] costs) {
        // parent 초기화
        this.parent = new int[n];
        for(int i=0; i<n; i++){parent[i] = i;}
        
        // cost
        Arrays.sort(costs, (o1, o2) ->o1[2]-o2[2]);
        int cnt = 0, answer = 0;
        for(int[] cost : costs){
            if(cnt == n-1){ // 간선 수가 채워지면
                break;
            }
            // 주어진 두 다리 잇기: 서로 다른 집합일 경우에 이어줌
            if(findRoot(cost[0]) != findRoot(cost[1])){
                union(cost[0], cost[1]); // 간선 이어주기
                answer += cost[2]; // 비용 추가
                cnt++; // 간선 +1 
            }
            
        }
        
        
        return answer;
    }
}

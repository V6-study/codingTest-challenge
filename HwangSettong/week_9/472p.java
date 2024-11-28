//https://school.programmers.co.kr/learn/courses/30/lessons/87946

class Solution {
    int[][] dungeons;
    boolean[] visited; // 방문했으면 true
    int n; // 던전 개수
    int answer = 0;
    
    // 백트래킹 함수. 파라미터: 던전 인덱스, 탐험한 던전 수, 현재 피로도
    void backtracking(int idx, int count, int p){ 
        // 백트래킹 조건: 최소 필요 피로도가 현재 피로도보다 크거나, 현재 피로도가 0보다 작음.
        if(dungeons[idx][0] > p){ 
            return;
        }
        answer = Math.max(count, answer);
        visited[idx] = true; // 방문 표시
        for(int i=0; i<n; i++){
            if(!visited[i]) backtracking(i, count+1, p-dungeons[idx][1]); // 탐색
        }
        visited[idx] = false; // 백트래킹을 위해 방문 취소
    }
    
    
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.n = dungeons.length;
        this.visited = new boolean[n];
        for(int i=0; i<n; i++){
            backtracking(i, 1, k); // 하나씩 돌아가면서 첫번째 탐색 던전으로 설정
        }
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/43162
class Solution {
    
    int dfs(int[][] computers, int i, int cnt){
        for(int k = 0; k<computers.length; k++){
            if(computers[i][k] == 1){ // 연결된 컴퓨터면
                // 방문했으니 0으로 바꿔줌
                computers[k][i] = 0; 
                computers[i][k] = 0;
                cnt = dfs(computers, k, cnt+1);
            }
        }
        return cnt; 

    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < n; i++){
            // 탐색 결과 반환값이 0이 아니면 1 더해줌
            answer += dfs(computers, i , 0) > 0 ? 1 : 0; 
        }
        return answer;
    }
}

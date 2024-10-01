// https://school.programmers.co.kr/learn/courses/30/lessons/87946

class Solution {
    int[][] maps;
    boolean[] visited;
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        maps = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(k,0);
        
        return answer;
    }
    
    void dfs(int hp, int count){
        for(int i=0; i<maps.length; i++){
            answer = Math.max(answer, count);
            if(!visited[i] && maps[i][0]<=hp){
                visited[i] = true;
                hp-=maps[i][1];
                
                dfs(hp, count + 1);
                
                visited[i] = false;
                hp+=maps[i][1];
            }
        }
    }
}

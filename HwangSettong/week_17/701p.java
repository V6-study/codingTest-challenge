// [미로 탈출 명령어] https://school.programmers.co.kr/learn/courses/30/lessons/150365#
import java.util.*;
class Solution {
    private String answer = "impossible";
    private int[] dest;
    private int n, m, k;
    private boolean[][][] visit;
    private void escapeMaze(int x, int y, String path){
        // 탐색했거나 정답을 구했으면 return
        if(visit[x][y][path.length()] || !answer.equals("impossible")) return;
        visit[x][y][path.length()] = true; // 탐색 여부 저장
        
        // 이동거리가 k이면 더 이상 탐색할 필요 없음
        if(path.length() == k){
            if(dest[0] == x && dest[1] == y) answer = path; // 도착지 도달 시 경로 저장
            return; // 재귀호출 중단
        }
        
        // 알파벳 사전 순으로 이동 (d->l->r->u)
        if(x < n-1) escapeMaze(x+1, y, path+"d");
        if(y > 0) escapeMaze(x, y-1, path+"l");
        if(y < m-1) escapeMaze(x, y+1, path+"r");
        if(x > 0) escapeMaze(x-1, y, path+"u");
    }
    
    
    
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n=n;
        this.m=m;
        this.k=k;
        this.dest = new int[] {r-1, c-1}; // 목적지
        this.visit = new boolean[n][m][k+1];
        escapeMaze(x-1, y-1, "");
        return answer;
    }
}

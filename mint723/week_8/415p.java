// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 10001;
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        while(!q.isEmpty()){
            int[] curPos = q.poll();
            for(int i=0; i<4; i++){
                int xPos = curPos[0] + dx[i];
                int yPos = curPos[1] + dy[i];
                if(xPos>=0 && yPos>=0 && xPos<n && yPos<m && !visited[xPos][yPos] && maps[xPos][yPos] == 1){
                    q.add(new int[]{xPos, yPos,curPos[2] + 1});
                    visited[xPos][yPos] = true;
                }
            }
            if(curPos[0] == n-1 && curPos[1] == m-1){
                answer = curPos[2];
            }
        }
        if(answer == 10001) answer = -1;
        
        return answer;
    }
}

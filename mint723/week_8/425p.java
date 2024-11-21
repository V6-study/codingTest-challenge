// https://school.programmers.co.kr/learn/courses/30/lessons/159993

import java.util.*;

class Solution {
    int n, m;
    char[][] map;
    int[] startPoint, lever, endPoint;
    
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public int solution(String[] maps) {
        // 레버로 도착
        // 이후 출구로 도착
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        
        startPoint = new int[2];
        lever = new int[2];
        endPoint = new int[2];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char character = maps[i].charAt(j);
                if(character == 'S'){
                    startPoint[0] = i;
                    startPoint[1] = j;
                }
                if(character == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
                if(character == 'E'){
                    endPoint[0] = i;
                    endPoint[1] = j;
                }
                
                if(character == 'X'){
                    map[i][j] = 'X';
                }else{
                    map[i][j] = 'O';
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        int n1 = bfs(startPoint, lever);
        
        int n2 = 0;
        
        if(n1 != 0){
             n2 = bfs(lever, endPoint);
        }
        
        return n1 == 0 || n2 == 0 ? -1 : n1 + n2;
    }
    
    int bfs(int[] start, int[] target){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] info = q.poll();
            int y = info[0];
            int x = info[1];
            
            if(y == target[0] && x == target[1]){
                return info[2];
            }
            
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < n &&  nx < m && ny>=0 && nx>=0 &&  map[ny][nx] == 'O' && !visited[ny][nx]){
                    q.offer(new int[]{ny, nx, info[2] + 1});
                    visited[ny][nx] = true;
                }
            }
        }
        
        return 0;
    }
}

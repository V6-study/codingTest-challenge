// https://school.programmers.co.kr/learn/courses/30/lessons/87694

import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        
        for(int i=0; i<rectangle.length; i++){
            int sx = rectangle[i][0] * 2;
            int sy = rectangle[i][1] * 2;
            int ex = rectangle[i][2] * 2;
            int ey = rectangle[i][3] * 2;
            
            // 테두리를 포함한 사각형 구간만큼 1로 변경
            for(int j=sy; j<=ey; j++){
                for(int k=sx; k<=ex; k++){
                    map[j][k] = 1;
                }
            }
        }
        
        for(int i=0; i<rectangle.length; i++){
            int sx = rectangle[i][0] * 2;
            int sy = rectangle[i][1] * 2;
            int ex = rectangle[i][2] * 2;
            int ey = rectangle[i][3] * 2;
            
            // 테두리를 포함하지 않은 사각형 구간만큼 0으로 변경
            for(int j=sy + 1; j<ey; j++){
                for(int k=sx + 1; k<ex; k++){
                    map[j][k] = 0;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        
        q.offer(new int[]{characterY * 2, characterX * 2, 0});
        visited[characterY * 2][characterX * 2] = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            if(itemY * 2 == arr[0] && itemX * 2 == arr[1])
                return arr[2]/2;
            
            for(int i=0; i<4; i++){
                int ny = arr[0] + dy[i];
                int nx = arr[1] + dx[i];
                if(ny>=0 && ny<=100 && nx>=0 && nx<=100 &&!visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx,arr[2] + 1});
                }
            }
        }
        return -1;
    }
}

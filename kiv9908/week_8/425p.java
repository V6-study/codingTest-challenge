import java.util.*;

class Solution {
    static String[][] map;
    static int sX, sY;
    static int lX, lY;
    static int eX, eY;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(String[] maps) {
        int answer = 0;
        map = new String[maps.length][maps[0].length()];
        
        for(int i = 0; i<maps.length;i++){
            for(int j = 0; j<maps[0].length();j++){
                map[i][j] = maps[i].charAt(j)+"";
                if(map[i][j].equals("S")){
                    sX = i;
                    sY = j;
                }else if(map[i][j].equals("L")){
                    lX = i;
                    lY = j;
                }else if(map[i][j].equals("E")){
                    eX = i;
                    eY = j;
                }
            }
        }
        
        int toLever = bfs(sX,sY,lX,lY);
        int toEnd = bfs(lX,lY,eX,eY);
        answer = (toLever == -1 || toEnd == -1) ? -1 : (toLever + toEnd);
        return answer;
    }
    
    private static int bfs(int startX, int startY, int endX, int endY){
        int[][] dist = new int[map.length][map[0].length];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {startX,startY});
        dist[startX][startY] = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0;i<4;i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<map.length && ny<map[0].length && nx>=0 && ny>=0){
                    if(!map[nx][ny].equals("X") && dist[nx][ny] == 0){
                        q.offer(new int[] {nx,ny});
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;
                    }
                }
                if(nx == endX && ny == endY){
                    return dist[nx][ny] -1;
                }
            }
        }
        return -1;
    }
}
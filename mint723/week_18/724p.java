import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        int[] dy = {0,0,-1,1};
        int[] dx = {1,-1,0,0};
        
        for(int k=0; k<n; k++){
            answer[k] = 1;
            
            String[] place = places[k];
            List<int[]> start = new ArrayList<>();
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(place[i].charAt(j)=='P')
                        start.add(new int[]{i,j});
                }
            }            
            
            for(int[] pos : start){
                boolean[][] visited = new boolean[5][5];
                Queue<int[]> q = new ArrayDeque();
                q.offer(new int[]{pos[0], pos[1], 0});
                visited[pos[0]][pos[1]] = true;
                
                while(!q.isEmpty()){
                    int[] info = q.poll();
                    int y = info[0];
                    int x = info[1];
                    int dist = info[2];
                    if(dist>2) continue;
                    for(int i=0; i<4; i++){
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        if(ny>=0 && nx>=0 && ny<5 && nx<5 && !visited[ny][nx]){
                            if(place[ny].charAt(nx) == 'O'){
                                q.offer(new int[]{ny,nx,dist+1});
                                visited[ny][nx] = true;
                            }else if(place[ny].charAt(nx) == 'P' && dist < 2){
                                answer[k] = 0;
                                break;
                            }
                        }
                    }
                }   
            }
        }
        return answer;
    }
}

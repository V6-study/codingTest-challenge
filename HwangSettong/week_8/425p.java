import java.util.*;
class Solution {
    int n, m; // x, y 수
    int[] s, e, l; // 시작점, 출구, 레버 위치 {x,y}
    String[][] map; // map
    String[][] visited; // 방문 표시
    int[][] direct = {{1,0}, {0,1}, {-1,0}, {0,-1}}; // 방문 방향 조작 
    
    
    // 값 초기화 함수
    void init(String[] origin){
        n = origin.length;
        m = origin[0].length();
        map = new String[n][m];
        
        String[] temp;
        for(int x = 0; x<n; x++){
            temp = origin[x].split("");
            for(int y=0; y<m; y++){
                map[x][y] = temp[y];
                if("S".equals(temp[y])) s = new int[] {x, y};
                if("E".equals(temp[y])) e = new int[] {x, y};
                if("L".equals(temp[y])) l = new int[] {x, y};
            }
        }
    }
    
    
    // 탐색 함수
    int bfs(int[] start, int[] dest){
        boolean[][] visited = new boolean[n][m]; // 방문 표시
        Queue<int[]> path = new LinkedList<>(); // {x, y, count}
        path.offer(new int[] {start[0], start[1], 0}); // 시작점 add
        visited[start[0]][start[1]] = true;
        
        int x, y;
        while(!path.isEmpty()){
            int[] cur = path.poll();
            // 목적지에 도달하면 시간 반환
            if(dest[0] == cur[0] && dest[1] == cur[1]) return cur[2];
            
            
            // direct 순회하며 다음 방문할 방향 정하기
            for(int i=0; i<4; i++){ 
                x = direct[i][0] + cur[0];
                y = direct[i][1] + cur[1];
                
                // 막힌 길이면 continue
                if(x<0||x>=n||y<0||y>=m||map[x][y].equals("X")) continue;
                // 방문한거면 continue
                if(visited[x][y]) continue;
                // 다음 경로 path에 추가해주고 visited update
                path.offer(new int[] {x, y , cur[2]+1});
                visited[x][y] = true;
            }
        }
        
        
        return -1;
    }
    
    public int solution(String[] maps) {
        // 초기화
        init(maps);
        
        int answer = bfs(s, l);
        if(answer == -1) return -1;
        int temp = bfs(l, e);
        if(temp == -1) return -1;
        return answer+temp;
    }
    
    
}

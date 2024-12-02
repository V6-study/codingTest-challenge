// https://www.acmicpc.net/problem/2206
import java.io.*;
import java.util.*;

public class Main {
    static String[] map; // map
    static int[][][] visited; // 최소 이동 횟수
    static int n, m; // 행, 렬
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static int bfs(){
        Queue<int[]> path = new LinkedList<>(); //{ x, y, 벽 부수기 여부}
        path.add(new int[] {0,0,0});
        visited = new int[n][m][2]; // {{{벽 부쉈을 때 이동횟수, 벽 안부쉈을 때 이동 횟수}}}
        visited[0][0][0] = 1;
        while(!path.isEmpty()){
            int[] info = path.poll();
            for(int i = 0; i < 4; i++){
                int nextX = info[0] + dx[i];
                int nextY = info[1] + dy[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue; // map 범위 벗어나면 continue;
                if(map[nextX].charAt(nextY) == '1') { // 벽이면
                    if(info[2] == 1) continue; // 현재 경로가 벽을 부수고 온 경로면 continue
                    // visited[nextX][nextY][1]에 저장된 이동횟수가 없거나, 현재 이동횟수보다 클 때 현재 이동횟수로 저장
                    if(visited[nextX][nextY][1]==0 || visited[nextX][nextY][1] > visited[info[0]][info[1]][0]+1){
                        visited[nextX][nextY][1] = visited[info[0]][info[1]][0]+1;
                        path.offer(new int[] {nextX, nextY, 1});
                    }
                } else { // 벽이 아니면
                    // result[nextX][nextY][flag]에 저장된 이동횟수가 없거나, 현재 이동횟수보다 클 때 현재 이동횟수로 저장
                    if(visited[nextX][nextY][info[2]] == 0 || visited[nextX][nextY][info[2]] > visited[info[0]][info[1]][info[2]]+1){
                        visited[nextX][nextY][info[2]] = visited[info[0]][info[1]][info[2]]+1;
                        path.offer(new int[] {nextX, nextY, info[2]});
                    }

                }
            }

        }

        if(visited[n-1][m-1][0] == 0) return visited[n-1][m-1][1];
        else if(visited[n-1][m-1][1] == 0) return visited[n-1][m-1][0];
        return Math.min(visited[n-1][m-1][1], visited[n-1][m-1][0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        map = new String[n];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        int answer = bfs();
        System.out.println(answer==0?-1:answer);

    }
}

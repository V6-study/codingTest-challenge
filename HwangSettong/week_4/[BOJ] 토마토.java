//https://www.acmicpc.net/problem/7576
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[mn[1]][mn[0]];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < mn[1]; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < mn[0]; j++){
                if(map[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        //bfs
        int[] dx = {1,-1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[] xy;
        int x, y;
        while(!queue.isEmpty()){
            xy = queue.poll();
            for(int d = 0; d < 4; d++){
                x = xy[0] + dx[d];
                y = xy[1] + dy[d];
                if(x >= 0 && x < mn[1] && y >= 0 && y < mn[0]){
                    if(map[x][y] == 0){
                        map[x][y] = map[xy[0]][xy[1]] + 1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        // check
        int max = 0;
        for(int i = 0; i < mn[1]; i++){
            for(int j = 0; j < mn[0]; j++){
                if(map[i][j] == 0){
                    System.out.println("-1");
                    return;
                }
                if(map[i][j] >  max){
                    max = map[i][j];
                }
            }
        }
        System.out.println(max-1);
    }
}

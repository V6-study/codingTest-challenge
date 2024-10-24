//https://www.acmicpc.net/problem/14940
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int[][] map = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int x=0;x<n;x++){
            temp = br.readLine().split(" ");
            for(int y=0;y<m;y++){
                map[x][y] = Integer.parseInt(temp[y]);
                if(map[x][y]==2){q.offer(new int[]{x,y,0});}
            }
        }

        // bfs
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int[] now;
        int x,y;

        while(!q.isEmpty()){
            now = q.poll();
            map[now[0]][now[1]] = now[2];
            for(int d=0;d<4;d++){
                x=now[0]+dx[d];
                y=now[1]+dy[d];
                if(x>=0 && x<n && y>=0 && y<m && map[x][y] == 1){
                    map[x][y] = now[2]-1;
                    q.add(new int[]{x,y,now[2]-1});
                }
            }

        }

        // answer
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                bw.write(-1*map[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

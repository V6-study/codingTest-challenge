//https://www.acmicpc.net/problem/1012
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int m, n;
    static void dfs(int x, int y){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        if(map[x][y]==1){
            map[x][y]=0;
            for(int d=0;d<4;d++){
                if(x+dx[d] >= 0 && x+dx[d] < m && y+dy[d] >= 0 && y+dy[d] < n ){
                    dfs(x+dx[d],y+dy[d]);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int[] mnk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = mnk[0];
            n = mnk[1];
            map = new int[m][n];
            for(int k = 0; k < mnk[2]; k++) {
                int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map[xy[0]][xy[1]] = 1;
            }
            int cnt = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}

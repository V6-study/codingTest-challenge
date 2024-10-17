// https://www.acmicpc.net/problem/7576
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int M,N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1,-1, 0, 0};
        
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            answer = Math.max(answer, pos[2]);
            for(int i=0; i<4; i++){
                int my = pos[0] + dy[i];
                int mx = pos[1] + dx[i];
                
                if (isValid(my, mx) && map[my][mx] == 0) {
                    map[my][mx] = 1;
                    q.offer(new int[]{my, mx, pos[2]+1});
                }
            }
        }
        
        boolean flag = true;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    flag = false;
                }
            }
        }
        
        if(flag){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
        
        br.close();
    }
    
    static boolean isValid(int n, int m) {
        return n >= 0 && m >= 0 && n < N && m < M;
    }
}

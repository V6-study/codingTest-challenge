// https://www.acmicpc.net/problem/11724

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        int[][] map = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                answer ++;
                q.offer(i);
                visited[i] = true;
                while (!q.isEmpty()){
                    int num = q.poll();
                    for(int j=0; j<N+1; j++){
                        if(map[num][j] == 1 && !visited[j]){
                            visited[j] = true;
                            q.offer(j);
                        }
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}

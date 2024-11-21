// https://www.acmicpc.net/source/86706984

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];

        Queue<int[]> q = new LinkedList<>();

        visited[N] = true;
        q.offer(new int[]{N,0});

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int point = arr[0];
            int count = arr[1];
            if(point == K){
                System.out.println(count);
                break;
            }

            int[] nextPoints = {point*2, point-1, point+1};

            for(int i=0; i<3; i++){
                int nextPoint = nextPoints[i];
                if(0<=nextPoint && nextPoint <= 100000 && !visited[nextPoint]){
                    visited[nextPoint] = true;
                    q.offer(new int[]{nextPoint, i==0 ? count : count+1});
                }
            }
        }
        br.close();
    }
}

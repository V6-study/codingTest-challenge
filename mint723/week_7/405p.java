// https://www.acmicpc.net/problem/24444

import java.util.*;
import java.io.*;

class Main{
    static int N,M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int startPoint = Integer.parseInt(st.nextToken());

        int count = 1;

        List<Integer>[] list = new List[N+1];
        boolean[] visited = new boolean[N+1];
        int[] answer = new int[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());

            list[point1].add(point2);
            list[point2].add(point1);
        }

        for(int i=0; i<N; i++){
            Collections.sort(list[i]);
        }
        Queue<Integer> q = new LinkedList<>();

        visited[startPoint] = true;
        q.offer(startPoint);
        answer[startPoint] = count++;

        while(!q.isEmpty()){
            int point = q.poll();
            for(int n : list[point]){
                if(!visited[n]){
                    visited[n] = true;
                    answer[n] = count++;
                    q.offer(n);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}

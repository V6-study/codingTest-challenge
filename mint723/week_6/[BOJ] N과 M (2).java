// https://www.acmicpc.net/problem/15650

import java.io.*;
import java.util.*;

class Main {

    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        dfs(1,0,new int[M+1]);
        System.out.println(sb);
    }

    static void dfs(int n, int depth, int[] arr){
        if(depth == M){
            for (int i = 0; i < arr.length-1; i++) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.append("\n");
        }else{
            for (int i = n; i <= N; i++) {
                arr[depth] = i;
                dfs(i+1, depth+1,arr);
            }
        }
    }
}

// https://www.acmicpc.net/problem/9663

import java.io.*;

public class Main {
    static int[] arr;
    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(answer);
        br.close();
    }

    static void dfs(int depth){
        if(depth == N){
            answer ++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if(isValid(depth)){
                dfs(depth+1);
            }
        }
    }

    static boolean isValid(int col){
        for (int i = 0; i < col; i++) { // 동일 행 검증
            if(arr[col] == arr[i]){
                return false;
            }
            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){ // 대각선 검증
                return false;
            }
        }
        return true;
    }
}

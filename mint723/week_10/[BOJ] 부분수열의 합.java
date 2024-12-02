import java.util.*;
import java.io.*;

class Main {
    static int answer = 0;
    static int N,S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        
        if(S == 0){
            answer--;
        }
        
        System.out.println(answer);
        br.close();
    }

    static void dfs(int idx, int sum){
        if(idx == N){
            if(sum == S){
                answer++;
            }
            return;
        }
        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum);
    }
}

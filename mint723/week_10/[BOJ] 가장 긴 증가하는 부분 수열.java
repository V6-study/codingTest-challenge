import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp,1); // dp 초기 값을 1로 채워주기
        // 가장 짧은 증가하는 부분 수열의 길이는 1이므로

        int answer = 1;

        for(int i=2; i<=N; i++){
            for (int j = 1; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                // 현재 값이 이전 값보다 크고
                // 현재 증가하는 부분 수열의 길이가
                // 이전 값의 길이보다 작거나 같을 때
                // 길이 + 1
                    dp[i] = dp[j] + 1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }
		
        System.out.println(answer);
        br.close();
    }
}

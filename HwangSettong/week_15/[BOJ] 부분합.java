// https://www.acmicpc.net/problem/1806
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 각 index까지의 합을 저장하는 dp 배열
        int[] dp = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i+1] = dp[i]+arr[i];
        }

        int minLen = 1000001;
        // 투포인터 사용
        int pointer1 = 0;
        int pointer2 = 1;
        while(pointer1<n && pointer2<=n){
            if(dp[pointer2]-dp[pointer1] >= s){ // 연속된 수들의 부분합이 S 이상인 경우
                minLen = Math.min(minLen , pointer2 - pointer1); // 연속된 수들의 최소 길이
                pointer1++; // pointer1 이동
                if(pointer1 == pointer2) pointer2++; // pointer2 > pointer1 유지
            }else{
                pointer2++; // pointer2 이동
            }
        }
        
        if(minLen == 1000001) System.out.println(0);
        else System.out.println(minLen);

    }
}

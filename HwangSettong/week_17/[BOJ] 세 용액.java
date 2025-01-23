//https://www.acmicpc.net/problem/2473
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체 용액 수
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        long[] ans = {arr[0], arr[1], arr[2]};
        long minSum = 3000000000L;
        loop: for(int mid = 1; mid < N-2; mid++){
            int p1 = 0, p2 = N-1;
            while(p1<mid && mid<p2){
                long sum = arr[p1]+arr[mid]+arr[p2];
                if(Math.abs(sum) < minSum){
                    minSum = Math.abs(sum);
                    ans[0] = arr[p1];
                    ans[1] = arr[mid];
                    ans[2] = arr[p2];
                }
                if(sum > 0){
                    p2--;
                }else if (sum < 0){
                    p1++;
                }else{
                    break;
                }
            }
        }

        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);

    }
}

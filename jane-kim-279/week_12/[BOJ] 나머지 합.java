import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long result = 0;
        long[] count = new long[m];
        long[] modsum = new long[n+1];

        // N개의 수 입력 받으면서 누적합을 M으로 나눈 나머지를 배열 modsum에 저장한다.
        st = new StringTokenizer(bf.readLine());
        for(int i=1; i<n+1; i++) {
            modsum[i] = (modsum[i-1] + Integer.parseInt(st.nextToken())) % m;
            // 0-i까지의 합을 M으로 나눈 나머지가 0인 경우의 수 카운트
            if(modsum[i]==0) result++;
            // 나머지가 같은 인덱스의 수 카운팅
            count[(int) modsum[i]]++;
        }

        // modsum[j] % m == modsum[i-1] % m 을 만족하는 (i, j) 를 결과값에 더한다.
        // 즉, cnt[i](i가 나머지인 인덱스의 수)에서 2가지를 뽑는 경우의 수 카운팅한다.
        for(int i=0; i<m; i++) {
            if(count[i] > 1) result += (count[i] * (count[i]-1) / 2);
        }
        System.out.println(result);
    }
}

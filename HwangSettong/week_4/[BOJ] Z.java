// https://www.acmicpc.net/problem/1074
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nrc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long n = (int)Math.pow(2, nrc[0]);
        int r = nrc[1], c = nrc[2];
        int temp;
        long answer = 0;
        while(true){
            if(r<n/2 && c<n/2) {
                temp = 0;
            }else if (r<n/2 && c<n) {
                temp = 1;
                c -= n/2;
            }else if (r<n && c<n/2) {
                temp = 2;
                r -= n/2;
            }else {
                temp = 3;
                r -= n/2;
                c -= n/2;
            }
            answer += (n*n/4) * temp;
            if(n == 2) break;
            n /= 2;
        }
        System.out.println(answer);
    }
}

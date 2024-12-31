//https://www.acmicpc.net/problem/2166
/*
신발끈 공식:
좌표 (x1, y1), (x2, y2), ... , (xn, yn) 이 이루는 다각형의 면적은 다음과 같다.
|(x1y2 + x2y3 + ... + xny0) - (x2y1 + x3y2 + ... + x0yn)| / 2
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 좌표 개수 n
        int[] x = new int[n+1]; // x좌표 배열. x0, x1, ... xn, x0 을 담을 것이므로 크기는 n+1
        int[] y = new int[n+1]; // y좌표 배열. y0, y1, ... yn, y0 을 담을 것이므로 크기는 n+1
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        x[n] = x[0];
        y[n] = y[0];
      
        // (x1y2 + x2y3 + ... + xny0) - (x2y1 + x3y2 + ... + x0yn) 구하기
        double sum = 0;
        for(int i = 0; i < n; i++){
            sum += (double)x[i]*y[i+1];
            sum -= (double)x[i+1]*y[i];
        }
        System.out.printf("%.1f",Math.abs(sum)/2); // 2로 나눈 후 출력
    }
}

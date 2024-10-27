// https://www.acmicpc.net/problem/2141 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[][] towns = new long[n][2];  // [i][0]은 위치, [i][1]은 인구수
        long totalPeople = 0;
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            towns[i][0] = Long.parseLong(st.nextToken());  // 위치
            towns[i][1] = Long.parseLong(st.nextToken());  // 인구수
            totalPeople += towns[i][1];
        }
        
        Arrays.sort(towns, (a, b) -> Long.compare(a[0], b[0]));  // 위치 기준으로 정렬
        
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += towns[i][1];
            if(sum >= (totalPeople+1) / 2) {
                System.out.println(towns[i][0]);
                break;
            }
        }
    }
}

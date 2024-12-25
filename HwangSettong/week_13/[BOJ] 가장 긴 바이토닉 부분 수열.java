// https://www.acmicpc.net/problem/11054

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] asc = new int[n]; // 가장 긴 증가하는 부분 수열 저장
        int[] desc = new int[n]; // 가장 긴 감소하는 부분 수열 저장
        int res = 1;
        // 기준 index 왼쪽 최장 오룸차순 수열 길이 구하기
        for(int i=0; i<n; i++){ // 기준 index
            asc[i] = 1;
            for(int j=0; j<i; j++){ // 이전 index
                if(arr[i] > arr[j]) asc[i] = Math.max(asc[i], asc[j]+1); // 기준 index 값 > 이전 index 값
            }
        }
        // 기준 index 오른쪽 최장 내림차순 수열 길이 구하기
        for(int i=n-1; i>=0; i--){ // 기준 index
            desc[i] = 1;
            for(int j=n-1; j>i; j--){ // 다음 index
                if(arr[i] > arr[j]) desc[i] = Math.max(desc[i], desc[j]+1); // 기준 index 값 > 다음 index 값
            }
        }
        // 바이토닉 수열 길이 구하기
        for(int i=0; i<n; i++){
            res = Math.max(res, desc[i] + asc[i] - 1);
        }
        System.out.println(res);
    }
}

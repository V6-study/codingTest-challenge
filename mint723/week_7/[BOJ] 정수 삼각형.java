// https://www.acmicpc.net/problem/1932

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] list = new int[N][];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[i+1];
            for(int j=0; j<arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list[i] = arr;
        }

        for (int i = 1; i < N; i++) {
            int[] before = list[i - 1];
            int[] arr = list[i];
            arr[0] = arr[0] + before[0];
            arr[arr.length-1] = arr[arr.length-1] + before[before.length-1];
        }

        for (int i = 2; i < N; i++) {
            int[] before = list[i - 1];
            int[] arr = list[i];
            for(int j=1; j<arr.length-1; j++){
                int num = Math.max(before[j], before[j-1]);
                arr[j] = num + arr[j];
            }
        }

        Arrays.stream(list[N-1]).max().ifPresent(System.out::println);
    }
}

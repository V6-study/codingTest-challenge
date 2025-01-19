// https://www.acmicpc.net/problem/11663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] points = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int lower = lowerBound(points, start);
            int upper = upperBound(points, end);
            sb.append(upper - lower).append("\n");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] points, int target) {
        int low = 0;
        int high = points.length;
        while(low < high) {
            int mid = (low + high) / 2;
            if(points[mid] < target) {
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    private static int upperBound(int[] points, int target) {
        int low = 0;
        int high = points.length;
        while(low < high) {
            int mid = (low + high) / 2;
            if(points[mid] <= target) {
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }